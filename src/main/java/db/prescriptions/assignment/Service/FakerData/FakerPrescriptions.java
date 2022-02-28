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
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Ulcerex", 20, "stk.", "Ulcerex® er et middel mod mavesår - Tages pga. studiekammerater."), patientMartin, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Sovepiller", 50, "stk.", "Mod søvnproblemer pga. studiekammerater"), patientMartin, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Morfin", 20, "stk.", "Mod smerter pga. studiekammerater"), patientMartin, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Aspirin", 100, "stk.", "Mod hovedpine pga. studiekammerater"), patientMartin, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Rasilez", 10, "stk.", "Rasilez® er et middel mod forhøjet blodtryk - Tages pga. studiekammerater."), patientMartin, doctor));
        // Nicholas
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Yentreve", 20, "stk.", "Yentreve® er et middel mod ufrivillig vandladning - Tages af patienten for at undgå at tisse på gulvet alle vegne."), patientNicholas, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Microlax", 20, "stk.", "Microlax er et middel mod forstoppelse - Tages af patienten for ikke at være fuld af lort."), patientNicholas, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Vagifem", 20, "stk.", "Vagifem® er et østrogen-præparat til lokalbehandling i skeden."), patientNicholas, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Klorpromazin", 20, "stk.", "Klorpromazin er et middel mod skizofreni - Tages af patienten for at forhindre flere drabsforsøg."), patientNicholas, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Minoxidil", 20, "stk.", "Minoxidil er et middel mod hårløshed - Tages for at forhindre yderligere hårløshed."), patientNicholas, doctor));
        // Patrick
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Abilify", 20, "stk.", "Abilify® er et middel mod psykoser - Tages for at patienten kan færdes i offentligheden uden at skabe sig."), patientPatrick, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Campral", 20, "stk.", "Campral® er et middel mod alkoholmisbrug - Tages af patienten for at undgå store alkoholmængder."), patientPatrick, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Januvia", 20, "stk.", "Januvia® er et middel mod diabetes 2 - Tages af patienten grundes store indtag af sukkerholdige kager og energidrikke."), patientPatrick, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Doloproct", 20, "stk.", "Doloproct er et middel mod hæmorider - Tages af patienten for at slippe af med en årelang kamp mod hæmorider."), patientPatrick, doctor));
        prescriptionList.add(new Prescription(vf.getRandomDateFromNowTo(), new Medicine("Bromam", 20, "stk.", "Bromam® er et beroligende middel - Tages for at udligne mængden af energidrikke patienten drikker."), patientPatrick, doctor));

        return prescriptionList;
    }
}
