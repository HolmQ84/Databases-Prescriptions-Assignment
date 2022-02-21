package db.prescriptions.assignment.Service;

import com.github.javafaker.Faker;
import db.prescriptions.assignment.Model.Address;
import db.prescriptions.assignment.Model.City;
import db.prescriptions.assignment.Model.Person;
import db.prescriptions.assignment.Model.Street;
import db.prescriptions.assignment.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class FakerData {

    @Autowired
    PersonRepository personRepository;

    public void createFakePerson(boolean mf) throws ParseException {
        Faker faker = new Faker();

        Person person = new Person();
        person.setFirstname(faker.name().firstName());
        person.setFirstname(faker.name().lastName());
        // Generate CPR number.
        String birthdate = new SimpleDateFormat("ddMMyy").parse(faker.date().birthday(5, 80).toString()).toString();
        Random rand = new Random();
        String lastFourDigits = null;
        if (mf) {
            // If male.
            lastFourDigits = Integer.toString(1000+rand.nextInt((9998-1000)/2) *2) + 1;
        } else {
            // If female.
            lastFourDigits = Integer.toString(1000+rand.nextInt((9998-1000)/2) *2);
        }
        person.setCpr(Integer.parseInt(birthdate+lastFourDigits));
        person.setPassword(faker.crypto().toString());

        Address address = new Address();

        City city = new City();
        city.setCityName(faker.address().cityName());
        city.setPostalCode(Integer.parseInt(faker.address().zipCode()));

        Street street = new Street();
        street.setStreetName(faker.address().streetName());

        address.setCity(city);
        address.setStreet(street);
        address.setStreetNumber(String.valueOf(rand.nextInt(998) + 1));

        person.setAddress(address);

        personRepository.save(person);
    }
}
