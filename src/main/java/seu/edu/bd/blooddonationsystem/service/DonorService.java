package seu.edu.bd.blooddonationsystem.service;

import org.springframework.stereotype.Service;
import seu.edu.bd.blooddonationsystem.exception.ResourceAlreadyExistsException;
import seu.edu.bd.blooddonationsystem.exception.ResourceNotFoundException;
import seu.edu.bd.blooddonationsystem.model.Donor;
import seu.edu.bd.blooddonationsystem.repository.DonorRipositoy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DonorService {
    private DonorRipositoy donorRipositoy;

    public DonorService(DonorRipositoy donorRipositoy) {
        this.donorRipositoy = donorRipositoy;
    }

    public List<Donor> findAll() {
        List<Donor> donorList = new ArrayList<>();
        donorRipositoy.findAll().forEach(donorList::add);
        return donorList;

    }

    public Donor findById(long id) throws ResourceNotFoundException {
        Donor donor = donorRipositoy.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        return donor;
    }

    public Donor Create(Donor donor) throws ResourceAlreadyExistsException {
        if (donorRipositoy.existsById(donor.getId())) {
            throw new ResourceAlreadyExistsException();
        } else {
            Donor saveDonor = donorRipositoy.save(donor);
            return saveDonor;
        }
    }

    public Donor donorUpdate(long id, Donor donor) throws ResourceAlreadyExistsException {
        Optional<Donor> optionalDonor = donorRipositoy.findById(donor.getId());
        if (optionalDonor.isPresent()) {
            throw new ResourceAlreadyExistsException();
        } else {
            Donor update = donorRipositoy.save(donor);
            return update;
        }
    }


    public void deletedById(long id) {
        donorRipositoy.deleteById(id);
    }
}
