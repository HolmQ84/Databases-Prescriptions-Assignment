package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorId;
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;
    @OneToMany(mappedBy = "patientId")
    private List<Patient> patientList;
    @OneToMany(mappedBy = "doctor")
    private List<Prescription> prescription;
}
