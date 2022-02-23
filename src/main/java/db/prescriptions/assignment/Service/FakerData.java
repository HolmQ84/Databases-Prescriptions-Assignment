package db.prescriptions.assignment.Service;

import com.github.javafaker.Faker;
import db.prescriptions.assignment.Model.Address;
import db.prescriptions.assignment.Model.City;
import db.prescriptions.assignment.Model.Person;
import db.prescriptions.assignment.Model.Street;
import db.prescriptions.assignment.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class FakerData {

    public void createFakePerson(boolean mf, PersonRepository personRepository) {
        Faker faker = new Faker();

        Person person = new Person();
        person.setFirstname(faker.name().firstName());
        person.setLastname(faker.name().lastName());
        // Generate CPR number.
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
        Date birthdate = new Date(faker.date().birthday(5, 80).getTime());
        System.out.println("Created birthdate: " + birthdate);
        System.out.println("Created birthdate: " + sdf.format(birthdate));
        Random rand = new Random();
        String lastFourDigits = null;
        if (mf) {
            // If male.
            lastFourDigits = Integer.toString((rand.nextInt((9998-1000)/2) *2) + 1000);
        } else {
            // If female.
            lastFourDigits = Integer.toString((rand.nextInt((9998-1000)/2) *2) + 1001);
        }
        String cpr = (sdf.format(birthdate) +'-'+ lastFourDigits);
        System.out.println(cpr);
        person.setCpr(cpr);
        String password = faker.crypto().md5();
        System.out.println(password);
        person.setPassword(password);

        Address address = new Address();
        System.out.println("Before setStreetNumber");
        address.setStreetNumber(String.valueOf(rand.nextInt(98) + 1));
        System.out.println("After setStreetNumber");

        City city = new City();
        city.setCityName(faker.address().cityName());
        int postalCode = rand.nextInt(89998) + 10001;
        city.setPostalCode(postalCode);
        city.setAddress(address);
        System.out.println(city);

        Street street = new Street();
        street.setStreetName(faker.address().streetName());
        street.setAddress(address);
        System.out.println(street);

        System.out.println("Fejl herefter - 1");
        address.setCity(city);
        System.out.println("Fejl herefter - 2");
        address.setStreet(street);
        System.out.println("Fejl herefter - 3");
        person.setAddress(address);
        System.out.println("Fejl herefter - 4");
        System.out.println(person);
        personRepository.save(person);
    }
}