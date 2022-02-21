package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pharmacy")
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pharmacyId;
    @OneToOne(mappedBy = "addressId")
    private Address address;
}
