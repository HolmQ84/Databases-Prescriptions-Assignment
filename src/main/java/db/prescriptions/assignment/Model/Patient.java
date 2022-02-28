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
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "person_id" , nullable = false)
    private Person person;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id" , nullable = false)
    private Doctor doctor;

    public Patient(Person person, Doctor doctor) {
        this.person = person;
        this.doctor = doctor;
    }

    public Patient() {
    }
}
