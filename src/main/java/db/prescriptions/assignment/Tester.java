package db.prescriptions.assignment;

import com.github.javafaker.Faker;
import db.prescriptions.assignment.Service.FakerData.VariousFunctions;
import org.apache.tomcat.jni.Time;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Tester {

    public static void main(String[] args) throws ParseException {
        VariousFunctions vf = new VariousFunctions();
        System.out.println(vf.getRandomDateFromNowTo());
    }
}
