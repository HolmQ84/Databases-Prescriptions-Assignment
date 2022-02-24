package db.prescriptions.assignment.DTO;

import lombok.Data;

@Data
public class GenderResult {
    private String name;
    private String gender;
    private double probability;
    private int count;
}
