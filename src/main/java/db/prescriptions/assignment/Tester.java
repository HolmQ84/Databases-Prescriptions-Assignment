package db.prescriptions.assignment;

import com.github.javafaker.Faker;
import db.prescriptions.assignment.Service.FakerData.FakerPerson;

import java.text.ParseException;

public class Tester {

    public static void main(String[] args) throws ParseException {
        Faker faker = new Faker();
        FakerPerson fakerPerson = new FakerPerson();
        /*
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
        sdf.parse(String.valueOf(faker.date().birthday(5, 80)));
        System.out.println(sdf.parse(String.valueOf(faker.date().birthday(5, 80).getDate())));
        String birthdate = new SimpleDateFormat("ddMMyy").parse(faker.date().birthday(5, 80).toString()).toString();
        FakerData fakerData = new FakerData();
        fakerData.createFakePerson(true);
        */
        System.out.println(faker.address().cityName());
    }
}
