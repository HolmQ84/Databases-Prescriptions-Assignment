package db.prescriptions.assignment.Service;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.util.JSONPObject;
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
import java.util.Date;
import java.util.Random;

@Service
public class FakerData {

    public Person createFakePerson(PersonRepository personRepository) {
        Faker faker = new Faker();
        Person person = new Person();
        // Generate name.
        person.setFirstname(faker.name().firstName());
        person.setLastname(faker.name().lastName());
        // Generate Birthdate.
        Date birthdate = new Date(faker.date().birthday(0, 90).getTime());
        person.setBirthdate(birthdate);
        // Generating last 4 digits for CPR.
        Random rand = new Random();
        int lastFourDigits = (rand.nextInt((9998-1000)/2) *2) + 1000;
        if (checkGender(person.getFirstname()).equals("male")) lastFourDigits++;
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
        int postalCode = rand.nextInt(89998) + 10001;
        city.setPostalCode(postalCode);
        // Generate street.
        Street street = new Street();
        street.setStreetName(faker.address().streetName());
        // Creating address and generating input.
        Address address = new Address();
        address.setStreetNumber(String.valueOf(rand.nextInt(98) + 1));
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