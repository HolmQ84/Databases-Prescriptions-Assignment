package db.prescriptions.assignment.Controller;

import db.prescriptions.assignment.Model.Medicine;
import db.prescriptions.assignment.Model.Person;
import db.prescriptions.assignment.Model.Pharmacy;
import db.prescriptions.assignment.Model.Prescription;
import db.prescriptions.assignment.Repository.MedicineRepository;
import db.prescriptions.assignment.Repository.PersonRepository;
import db.prescriptions.assignment.Repository.PharmacyRepository;
import db.prescriptions.assignment.Repository.PrescriptionRepository;
import db.prescriptions.assignment.Service.EmailService;
import db.prescriptions.assignment.Repository.PrescriptionRepository;
import db.prescriptions.assignment.Service.FakerData.FakerMedicine;
import db.prescriptions.assignment.Service.FakerData.FakerPerson;
import db.prescriptions.assignment.Service.FakerData.FakerPharmacy;
import db.prescriptions.assignment.Service.FakerData.FakerPrescriptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    MedicineRepository medicineRepository;
    @Autowired
    PharmacyRepository pharmacyRepository;
    @Autowired
    PrescriptionRepository prescriptionRepository;


    @RequestMapping("/createManyPersons")
    public List<Person> createManyFakePersons() {
        FakerPerson fakerPerson = new FakerPerson();
        List<Person> personList = fakerPerson.createFakePersons(100);
        try {
            personRepository.saveAll(personList);
            return personList;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return new ArrayList<>();
        }
    }

    @RequestMapping("/createPerson")
    public Person createFakePerson() {
        FakerPerson fakerPerson = new FakerPerson();
        Person person = fakerPerson.createFakePerson();
        try {
            personRepository.save(person);
            return person;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return new Person();
        }
    }

    @RequestMapping("/createMedicine")
    public List<Medicine> createMedicine() {
        FakerMedicine fakerMedicine = new FakerMedicine();
        List<Medicine> medicineList = fakerMedicine.createFakeMedicine();
        try {
            medicineRepository.saveAll(medicineList);
            return medicineList;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return new ArrayList<>();
        }
    }

    @RequestMapping("/createPharmacies")
    public List<Pharmacy> createPharmacies() {
        FakerPharmacy fakerPharmacy = new FakerPharmacy();
        List<Pharmacy> pharmacyList = fakerPharmacy.createPharmacies(100);
        try {
            pharmacyRepository.saveAll(pharmacyList);
            return pharmacyList;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return new ArrayList<>();
        }
    }

    @RequestMapping("/createPrescriptions")
    public List<Prescription> createPrescriptions() throws ParseException {
        FakerPrescriptions fp = new FakerPrescriptions();
        List<Prescription> prescriptionList = fp.createPrescription();
        try {
            prescriptionRepository.saveAll(prescriptionList);
            System.out.println("Successfully created new Prescriptions.");
            return prescriptionList;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return new ArrayList<>();
        }
    }

    @RequestMapping("/fetchExpireingPerscriptionsEmails")
    public void fetchEmails() {
        EmailService emailService = new EmailService();
        List<String> emailsToSend = personRepository.fetchEmailsWherePrescriptionExpireInOneWeek();

        for (int i = 0; i < emailsToSend.size(); i++) {
            emailService.sendSimpleMessage(emailsToSend.get(i));
        }
    }
}


