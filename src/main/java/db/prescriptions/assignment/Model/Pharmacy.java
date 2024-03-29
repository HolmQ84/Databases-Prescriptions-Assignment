package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pharmacy")
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_id")
    private int pharmacyId;
    private String pharmacyName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    public Pharmacy() {

    }

    public Pharmacy(String pharmacyName, Address address) {
        this.pharmacyName = pharmacyName;
        this.address = address;
    }
}
