package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescriptionId;
    private Date expirationDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicine_id", nullable = false)
    private Medicine medicine;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_id", nullable = false)
    private Patient patient;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="doctor_id", nullable = false)
    private Doctor doctor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;
}
