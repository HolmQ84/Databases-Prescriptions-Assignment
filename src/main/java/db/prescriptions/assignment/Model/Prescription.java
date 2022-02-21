package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int prescriptionId;
    private Date expirationDate;
    @ManyToOne
    @JoinColumn(name = "medicine_id", nullable = false)
    private Medicine medicine;
    @ManyToOne
    @JoinColumn(name="patient_id", nullable = false)
    private Patient patient;
    @OneToOne(mappedBy = "doctorId", optional = false)
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;
}
