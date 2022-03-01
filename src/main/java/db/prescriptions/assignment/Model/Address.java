package db.prescriptions.assignment.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "street_id", referencedColumnName = "street_id")
    private Street street;
    private String streetNumber;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City city;
    private String country;

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street=" + street +
                ", streetNumber='" + streetNumber + '\'' +
                ", city=" + city +
                '}';
    }

    public Address() {
    }

    public Address(int addressId, Street street, String streetNumber, City city, String country) {
        this.addressId = addressId;
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.country = country;
    }

    public Address(Street street, String streetNumber, City city, String country) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.country = country;
    }
}
