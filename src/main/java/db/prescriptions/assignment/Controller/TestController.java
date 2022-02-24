package db.prescriptions.assignment.Controller;

import db.prescriptions.assignment.Model.Person;
import db.prescriptions.assignment.Repository.PersonRepository;
import db.prescriptions.assignment.Service.FakerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/createManyPersons")
    public List<Person> createManyFakePersons() {
        long startTime = System.currentTimeMillis();
        FakerData fakerData = new FakerData();
        List<Person> persons = fakerData.createFakePersons(100, personRepository);
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(elapsedTime);
        return persons;
    }

    @RequestMapping("/createPerson")
    public Person createFakePerson() {
        FakerData fakerData = new FakerData();
        return fakerData.createFakePerson(personRepository);
    }
}
