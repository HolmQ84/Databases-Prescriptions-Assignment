package db.prescriptions.assignment.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityId;
    private String cityName;
    private int postalCode;
}
