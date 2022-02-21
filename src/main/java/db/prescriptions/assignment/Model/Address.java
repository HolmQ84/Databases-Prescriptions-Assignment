package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;
    @OneToOne(mappedBy = "streetId")
    private Street street;
    private String streetNumber;
    @OneToOne(mappedBy = "cityId")
    private City city;
}
