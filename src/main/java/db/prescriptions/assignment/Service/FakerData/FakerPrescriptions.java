package db.prescriptions.assignment.Service.FakerData;

import db.prescriptions.assignment.Model.*;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class FakerPrescriptions {

    public List<Prescription> createPrescription() throws ParseException {
        List<Prescription> prescriptionList = new ArrayList<>();
        Date birthdateMartin = new GregorianCalendar(1984, Calendar.AUGUST, 10).getTime();
        Date birthdateNicholas = new GregorianCalendar(1989, Calendar.SEPTEMBER, 30).getTime();
        Date birthdatePatrick = new GregorianCalendar(1999, Calendar.APRIL, 18).getTime();
        FakerPerson fakerPerson = new FakerPerson();
        Person person = fakerPerson.createFakePerson();
        Doctor doctor = new Doctor(person);
        // Create Patients
        Patient patientMartin = new Patient(new Person("Martin","Holmqvist","cph-mh992@cphbusiness.dk",birthdateMartin,"100884-****","test1234", new Address(new Street("Cedervangen"), "41", new City("Allerød", 3450), "Denmark")), doctor);
        Patient patientNicholas = new Patient(new Person("Nicholas","Tureczek","cph-nt123@cphbusiness.dk",birthdateNicholas,"300989-****","test1234", new Address(new Street("Vejlegårdsparken"), "40 1.th", new City("Vallensbæk", 2665), "Denmark")), doctor);
        Patient patientPatrick = new Patient(new Person("Patrick","Jønsson","cph-pj241@cphbusiness.dk",birthdatePatrick,"180499-****","test1234", new Address(new Street("Ellemosevej"), "134", new City("Hellerup", 2900), "Denmark")), doctor);

        // Create Prescriptions
        VariousFunctions vf = new VariousFunctions();
        // Martin
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil", 20, "stk.", "Mod hovedpine"), patientMartin, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Sovepiller", 20, "stk.", "Mod hovedpine"), patientMartin, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil1", 20, "stk.", "Mod hovedpine"), patientMartin, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil1", 20, "stk.", "Mod hovedpine"), patientMartin, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil1", 20, "stk.", "Mod hovedpine"), patientMartin, doctor));
        // Nicholas
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil2", 20, "stk.", "Mod hovedpine"), patientNicholas, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil2", 20, "stk.", "Mod hovedpine"), patientNicholas, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil2", 20, "stk.", "Mod hovedpine"), patientNicholas, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil2", 20, "stk.", "Mod hovedpine"), patientNicholas, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil2", 20, "stk.", "Mod hovedpine"), patientNicholas, doctor));
        // Patrick
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil3", 20, "stk.", "Mod hovedpine"), patientPatrick, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil3", 20, "stk.", "Mod hovedpine"), patientPatrick, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil3", 20, "stk.", "Mod hovedpine"), patientPatrick, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil3", 20, "stk.", "Mod hovedpine"), patientPatrick, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Panodil3", 20, "stk.", "Mod hovedpine"), patientPatrick, doctor));

        return prescriptionList;
    }
}
