package db.prescriptions.assignment.Repository;

import db.prescriptions.assignment.Model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<Street, Integer> {
}
