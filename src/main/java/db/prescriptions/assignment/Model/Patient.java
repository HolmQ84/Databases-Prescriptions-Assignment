package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id" , nullable = false)
    private Doctor doctor;
}
