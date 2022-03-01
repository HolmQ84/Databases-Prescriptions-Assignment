package db.prescriptions.assignment.Repository;

import db.prescriptions.assignment.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Transactional
    @Query(value = "SELECT person.email FROM person" +
            " JOIN prescription ON person.person_id = prescription.patient_id" +
            " JOIN patient ON person.person_id = patient.patient_id" +
            " WHERE prescription.expiration_date = current_date  + 7", nativeQuery = true)
    List<String> fetchEmailsWherePrescriptionExpireInOneWeek();

}
