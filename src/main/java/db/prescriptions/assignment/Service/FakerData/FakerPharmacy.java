package db.prescriptions.assignment.Service.FakerData;

import com.github.javafaker.Faker;
import db.prescriptions.assignment.Model.Address;
import db.prescriptions.assignment.Model.City;
import db.prescriptions.assignment.Model.Pharmacy;
import db.prescriptions.assignment.Model.Street;
import db.prescriptions.assignment.Repository.PharmacyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FakerPharmacy {

    public List<Pharmacy> createPharmacies(int loopAmount, PharmacyRepository pharmacyRepository) {
        Random random = new Random();
        Faker faker = new Faker();
        List<Pharmacy> pharmacies = new ArrayList<>();
        for (int i = 0;i<loopAmount;i++) {
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
            String name = faker.address().cityName() + " Pharmacy";
            pharmacies.add(new Pharmacy(name, address));
        }
        try {
            pharmacyRepository.saveAll(pharmacies);
            System.out.println("Success! Created - "+loopAmount+" Pharmacies!");
            return pharmacies;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return new ArrayList<Pharmacy>();
        }
    }
}
