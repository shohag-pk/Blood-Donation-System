package seu.edu.bd.blooddonationsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import seu.edu.bd.blooddonationsystem.model.Donor;

import java.util.List;

@Repository
public interface DonorRipositoy extends CrudRepository<Donor, Long> {
    List<Donor> findByName(String name);
}
