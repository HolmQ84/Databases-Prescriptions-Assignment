package db.prescriptions.assignment.Controller;

import db.prescriptions.assignment.Repository.PersonRepository;
import db.prescriptions.assignment.Service.FakerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/test")
    public String tester() {
        FakerData fakerData = new FakerData();
        try {
            fakerData.createFakePerson(true, personRepository);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

        return "Test";
    }
}
