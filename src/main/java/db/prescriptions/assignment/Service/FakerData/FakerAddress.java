package db.prescriptions.assignment.Service.FakerData;

import com.github.javafaker.Faker;
import db.prescriptions.assignment.Model.Address;
import db.prescriptions.assignment.Model.City;
import db.prescriptions.assignment.Model.Street;

import java.util.Random;

public class FakerAddress {

    public Address createAddress() {
        Faker faker = new Faker();
        Random random = new Random();
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
        return address;
    }
}
