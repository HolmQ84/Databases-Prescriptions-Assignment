package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int medicineId;
    private String medicineName;
    private int amount;
    private String description;
}