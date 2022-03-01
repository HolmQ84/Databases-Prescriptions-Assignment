package db.prescriptions.assignment.Service.FakerData;

import com.github.javafaker.Faker;
import db.prescriptions.assignment.Model.Address;
import db.prescriptions.assignment.Model.Person;
import db.prescriptions.assignment.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FakerPerson {

    public List<Person> createFakePersons(int loopAmount) {
        List<Person> createdPersons = new ArrayList<>();
        Random random = new Random();
        Faker faker = new Faker();
        for (int i = 0;i<loopAmount;i++) {
            Person person = new Person();
            // Generate name.
            person.setFirstname(faker.name().firstName());
            person.setLastname(faker.name().lastName());
            // Generate email
            String shortname = "";
            if (person.getFirstname().length() < 3) {
                shortname += person.getFirstname().substring(0,2)+person.getLastname().substring(0,4);
            } else {
                shortname += person.getFirstname().substring(0,3)+person.getLastname().substring(0,3);
            }
            person.setEmail(shortname.toLowerCase(Locale.ROOT)+(random.nextInt(899)+100)+"@gmail.com");
            // Generate birthdate.
            Date birthdate = new Date(faker.date().birthday(0, 90).getTime());
            person.setBirthdate(birthdate);
            // Generating last 4 digits for CPR.
            int lastFourDigits = (random.nextInt((9998-1000)/2) *2) + 1000;
            VariousFunctions variousFunctions = new VariousFunctions();
            if (variousFunctions.checkGender(person.getFirstname())) lastFourDigits++;
            // Converting to correct CPR format.
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
            String cpr = (sdf.format(birthdate) +'-'+ lastFourDigits);
            person.setCpr(cpr);
            // Generate password.
            String password = faker.crypto().md5();
            person.setPassword(password);
            // Get random address.
            FakerAddress fakerAddress = new FakerAddress();
            Address address = fakerAddress.createAddress();
            person.setAddress(address);
            // Save the new person.
            createdPersons.add(person);
        }
        return createdPersons;
    }

    public Person createFakePerson() {
        Random random = new Random();
        Faker faker = new Faker();
        Person person = new Person();
        // Generate name.
        person.setFirstname(faker.name().firstName());
        person.setLastname(faker.name().lastName());
        // Generate email
        String shortname = person.getFirstname().substring(0,3)+person.getLastname().substring(0,3);
        person.setEmail(shortname.toLowerCase(Locale.ROOT)+(random.nextInt(899)+100)+"@gmail.com");
        // Generate Birthdate.
        Date birthdate = new Date(faker.date().birthday(0, 90).getTime());
        person.setBirthdate(birthdate);
        // Generating last 4 digits for CPR.
        int lastFourDigits = (random.nextInt((9998-1000)/2) *2) + 1000;
        VariousFunctions variousFunctions = new VariousFunctions();
        if (variousFunctions.checkGender(person.getFirstname())) lastFourDigits++;
        // Converting to correct CPR format.
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
        String cpr = (sdf.format(birthdate) +'-'+ lastFourDigits);
        person.setCpr(cpr);
        // Generate password.
        String password = faker.crypto().md5();
        person.setPassword(password);
        // Get random address.
        FakerAddress fakerAddress = new FakerAddress();
        Address address = fakerAddress.createAddress();
        person.setAddress(address);

        return person;
    }
}
