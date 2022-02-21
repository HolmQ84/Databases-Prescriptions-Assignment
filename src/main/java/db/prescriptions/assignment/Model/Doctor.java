package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int doctorId;
    @OneToOne(mappedBy = "personId")
    private Person person;
    @OneToMany(mappedBy = "patientId")
    private List<Patient> patientList;
}
