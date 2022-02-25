package db.prescriptions.assignment.Controller;

import db.prescriptions.assignment.Model.Medicine;
import db.prescriptions.assignment.Model.Person;
import db.prescriptions.assignment.Model.Pharmacy;
import db.prescriptions.assignment.Repository.MedicineRepository;
import db.prescriptions.assignment.Repository.PersonRepository;
import db.prescriptions.assignment.Repository.PharmacyRepository;
import db.prescriptions.assignment.Service.FakerData.FakerMedicine;
import db.prescriptions.assignment.Service.FakerData.FakerPerson;
import db.prescriptions.assignment.Service.FakerData.FakerPharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    MedicineRepository medicineRepository;
    @Autowired
    PharmacyRepository pharmacyRepository;

    @RequestMapping("/createManyPersons")
    public List<Person> createManyFakePersons() {
        long startTime = System.currentTimeMillis();
        FakerPerson fakerPerson = new FakerPerson();
        List<Person> persons = fakerPerson.createFakePersons(100, personRepository);
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time taken to complete the task: "+elapsedTime + " ms.");
        return persons;
    }

    @RequestMapping("/createPerson")
    public Person createFakePerson() {
        FakerPerson fakerPerson = new FakerPerson();
        return fakerPerson.createFakePerson(personRepository);
    }

    @RequestMapping("/createMedicine")
    public List<Medicine> createMedicine() {
        FakerMedicine fakerMedicine = new FakerMedicine();
        return fakerMedicine.createFakeMedicine(medicineRepository);
    }

    @RequestMapping("/createPharmacies")
    public List<Pharmacy> createPharmacies() {
        FakerPharmacy fakerPharmacy = new FakerPharmacy();
        return fakerPharmacy.createPharmacies(100, pharmacyRepository);
    }
}
