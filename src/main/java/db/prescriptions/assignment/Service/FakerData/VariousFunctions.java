package db.prescriptions.assignment.Service.FakerData;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import db.prescriptions.assignment.DTO.GenderResult;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class VariousFunctions {

    public boolean checkGender(String firstname) {
        String url = "https://api.genderize.io/?name="+firstname;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        GenderResult genderResult = gson.fromJson(result, GenderResult.class);
        return genderResult.getGender().equals("male");
    }

    public Date getRandomDateFromNowTo() {
        Faker faker = new Faker();
        Date d1 = new Date();
        LocalDateTime now =  LocalDateTime.now();
        Date d2 = java.util.Date.from(now.plusMonths(6).atZone(ZoneId.systemDefault()).toInstant());
        return faker.date().between(d1, d2);
    }
}
