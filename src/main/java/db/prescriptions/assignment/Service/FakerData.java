package db.prescriptions.assignment.Service;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import db.prescriptions.assignment.DTO.GenderResult;
import db.prescriptions.assignment.Model.Address;
import db.prescriptions.assignment.Model.City;
import db.prescriptions.assignment.Model.Person;
import db.prescriptions.assignment.Model.Street;
import db.prescriptions.assignment.Repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FakerData {

    public List<Person> createFakePersons(int loopAmount, PersonRepository personRepository) {
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
            // Generate Birthdate.
            Date birthdate = new Date(faker.date().birthday(0, 90).getTime());
            person.setBirthdate(birthdate);
            // Generating last 4 digits for CPR.
            int lastFourDigits = (random.nextInt((9998-1000)/2) *2) + 1000;
            String gender = checkGender(person.getFirstname());
            if (gender.equals("male") || gender.equals("null")) lastFourDigits++;
            // Converting to correct CPR format.
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
            String cpr = (sdf.format(birthdate) +'-'+ lastFourDigits);
            person.setCpr(cpr);
            // Generate password.
            String password = faker.crypto().md5();
            person.setPassword(password);
            // Generate city and postal code.
            City city = new City();
            city.setCityName(faker.address().cityName());
            int postalCode = random.nextInt(89998) + 10001;
            city.setPostalCode(postalCode);
            // Generate street.
            Street street = new Street();
            street.setStreetName(faker.address().streetName());
            // Creating address and generating input.
            Address address = new Address();
            address.setStreetNumber(String.valueOf(random.nextInt(98) + 1));
            address.setCountry(faker.address().country());
            address.setCity(city);
            address.setStreet(street);
            person.setAddress(address);
            // Save the new person.
            try {
                System.out.println(person);
                personRepository.save(person);
                createdPersons.add(person);
            } catch (Exception e) {
                e.printStackTrace();
                createdPersons.add((new Person()));
            }
        }
        return createdPersons;
    }

    public Person createFakePerson(PersonRepository personRepository) {
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
        String gender = checkGender(person.getFirstname());
        if (gender.equals("male") || gender.equals("null")) lastFourDigits++;
        // Converting to correct CPR format.
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
        String cpr = (sdf.format(birthdate) +'-'+ lastFourDigits);
        person.setCpr(cpr);
        // Generate password.
        String password = faker.crypto().md5();
        person.setPassword(password);
        // Generate city and postal code.
        City city = new City();
        city.setCityName(faker.address().cityName());
        int postalCode = random.nextInt(89998) + 10001;
        city.setPostalCode(postalCode);
        // Generate street.
        Street street = new Street();
        street.setStreetName(faker.address().streetName());
        // Creating address and generating input.
        Address address = new Address();
        address.setStreetNumber(String.valueOf(random.nextInt(98) + 1));
        address.setCountry(faker.address().country());
        address.setCity(city);
        address.setStreet(street);
        person.setAddress(address);
        // Save the new person.
        try {
            System.out.println(person);
            personRepository.save(person);
            return person;
        } catch (Exception e) {
            e.printStackTrace();
            return new Person();
        }
    }

    public String checkGender(String firstname) {
        String url = "https://api.genderize.io/?name="+firstname;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        GenderResult genderResult = gson.fromJson(result, GenderResult.class);
        System.out.println(genderResult.getGender());
        return genderResult.getGender();
    }
}
