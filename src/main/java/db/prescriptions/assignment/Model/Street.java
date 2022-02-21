package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="street")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int streetId;
    private String streetName;
}
