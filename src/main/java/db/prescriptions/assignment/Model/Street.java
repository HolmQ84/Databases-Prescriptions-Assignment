package db.prescriptions.assignment.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name="street")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "street_id")
    private int streetId;
    private String streetName;

    @Override
    public String toString() {
        return "Street{" +
                "streetId=" + streetId +
                ", streetName='" + streetName + '\'' +
                '}';
    }

    public Street(String streetName) {
        this.streetName = streetName;
    }

    public Street() {
    }
}
