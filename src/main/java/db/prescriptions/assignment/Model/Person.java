package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personId;
    private String firstname;
    private String lastname;
    private int cpr;
    private String password;
    @OneToOne(mappedBy = "addressId")
    private Address address;
}
