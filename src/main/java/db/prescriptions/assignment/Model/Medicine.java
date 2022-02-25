package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private int medicineId;
    private String medicineName;
    private int amount;
    private String amountType;
    private String description;

    public Medicine() {

    }

    public Medicine(String medicineName, int amount, String amountType, String description) {
        this.medicineName = medicineName;
        this.amount = amount;
        this.amountType = amountType;
        this.description = description;
    }
}