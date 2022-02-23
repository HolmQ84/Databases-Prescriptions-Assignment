package db.prescriptions.assignment.Controller;

import db.prescriptions.assignment.Model.Person;
import db.prescriptions.assignment.Repository.PersonRepository;
import db.prescriptions.assignment.Service.FakerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/createPerson")
    public Person tester() {
        FakerData fakerData = new FakerData();
        return fakerData.createFakePerson(personRepository);
    }
}
