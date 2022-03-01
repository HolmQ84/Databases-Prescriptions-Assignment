package db.prescriptions.assignment.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;
    private String firstname;
    private String lastname;
    private String email;
    private Date birthdate;
    private String cpr;
    private String password;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    public Person(String firstname, String lastname, String email, Date birthdate, String cpr, String password, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.cpr = cpr;
        this.password = password;
        this.address = address;
    }

    public Person() {
    }
}
