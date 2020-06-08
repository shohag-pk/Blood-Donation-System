package seu.edu.bd.blooddonationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import seu.edu.bd.blooddonationsystem.exception.ResourceAlreadyExistsException;
import seu.edu.bd.blooddonationsystem.exception.ResourceNotFoundException;
import seu.edu.bd.blooddonationsystem.model.Donor;
import seu.edu.bd.blooddonationsystem.service.DonorService;

import java.util.List;

@RestController
@RequestMapping("donors")
public class DonorController {
    @Autowired
    private DonorService donorService;

    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }


    @GetMapping("")
    public ResponseEntity<List<Donor>> getDonors() {
        List<Donor> donorList = donorService.findAll();
        return ResponseEntity.ok(donorList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donor> getDonor(@PathVariable long id) {
        try {
            Donor donor = donorService.findById(id);
            return ResponseEntity.ok(donor);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Donor> createDonor(@RequestBody Donor donor) {
        try {
            Donor createDonor = donorService.Create(donor);
            return ResponseEntity.status(HttpStatus.CREATED).body(createDonor);
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Donor> updateDonor(@RequestBody Donor donor) {
        try {
            Donor updateDonor = donorService.Create(donor);
            return ResponseEntity.status(HttpStatus.CREATED).body(updateDonor);
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{id}")
    public void deleteDonor(@PathVariable long id) {
        donorService.deletedById(id);
    }

}
