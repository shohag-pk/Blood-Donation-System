package seu.edu.bd.blooddonationsystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import seu.edu.bd.blooddonationsystem.model.Donor;
import seu.edu.bd.blooddonationsystem.repository.DonorRipositoy;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class BloodDonationSystemApplicationTests {
    @Autowired
    private DonorRipositoy donorRipositoy;

    @Test
    void contextLoads() {
    }

    @Test
    void readDonor() {
        Donor donor = new Donor(2001l, "Monirul Hasan", "A+", "Dhaka", "01971936618", "kmh@seu.edu.bd", LocalDate.now());
        Donor saveDonor = donorRipositoy.save(donor);
        System.out.println(saveDonor);
    }

    @Test
    public void readDonorByName() {

        Donor donor = new Donor();
        donor.setId(2002);
        donor.setName("Shohag pk");
        donor.setBlood_group("A+");
        donor.setAddress("pabna");
        donor.setPhone_number("01758908899");
        donor.setEmail("20161000000142@seu.edu.bd");
        donor.setDateOfBirth(LocalDate.now());
        donorRipositoy.save(donor);
        donor.setId(2003);
        donor.setName("Hridoy Fokir");
        donor.setBlood_group("O+");
        donor.setAddress("pabna");
        donor.setPhone_number("01717216109");
        donor.setEmail("heart@gmail.com");
        donor.setDateOfBirth(LocalDate.now());
        donorRipositoy.save(donor);
        donor.setId(2004);
        donor.setName("Hridoy Heart");
        donor.setBlood_group("B+");
        donor.setAddress("pabna");
        donor.setPhone_number("01785556606");
        donor.setEmail("heart.tonni@gmail.com");
        donor.setDateOfBirth(LocalDate.now());
        donorRipositoy.save(donor);
        donor.setId(2005);
        donor.setName("Hridoy khan");
        donor.setBlood_group("O-");
        donor.setAddress("Dhaka");
        donor.setPhone_number("01711332255");
        donor.setEmail("hridoy.official@gmail.com");
        donor.setDateOfBirth(LocalDate.now());
        donorRipositoy.save(donor);

        List<Donor> donorList = donorRipositoy.findByName("Hridoy khan");
        donorList.stream().forEach(System.out::println);
    }

}
