package db.prescriptions.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DatabasesPrescriptionsAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabasesPrescriptionsAssignmentApplication.class, args);
    }

}
