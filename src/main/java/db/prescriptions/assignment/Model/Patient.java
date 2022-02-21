package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patientId;
    @OneToOne(mappedBy = "personId")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
}
