package seu.edu.bd.blooddonationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Donor {
    @Id
    private long id;
    private String name;
    private String blood_group;
    private String address;
    private String phone_number;
    private String email;
    private LocalDate dateOfBirth;
}
