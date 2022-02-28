package db.prescriptions.assignment.Service.FakerData;

import com.github.javafaker.Faker;
import db.prescriptions.assignment.Model.Address;
import db.prescriptions.assignment.Model.Pharmacy;
import db.prescriptions.assignment.Repository.PharmacyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakerPharmacy {

    public List<Pharmacy> createPharmacies(int loopAmount) {
        Faker faker = new Faker();
        List<Pharmacy> pharmacies = new ArrayList<>();
        for (int i = 0;i<loopAmount;i++) {
            FakerAddress fakerAddress = new FakerAddress();
            Address address = fakerAddress.createAddress();
            String name = faker.address().cityName() + " Pharmacy";
            pharmacies.add(new Pharmacy(name, address));
        }
        return pharmacies;
    }
}
