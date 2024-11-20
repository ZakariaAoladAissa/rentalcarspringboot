package com.example.carRental.services;

import com.example.carRental.models.Car;
import com.example.carRental.models.Rent;
import com.example.carRental.models.User;
import com.example.carRental.repositories.CarsRepository;
import com.example.carRental.repositories.RentRepository;
import com.example.carRental.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    private final RentRepository rentRepository;
    private final CarsRepository carRepository;
    private final UserRepository userRepository;

    @Autowired
    public RentService(RentRepository rentRepository, CarsRepository carRepository, UserRepository userRepository) {
        this.rentRepository = rentRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }
    public List<Rent> getAllRent(){return rentRepository.findAll();}

    public List<Rent> getUserRents(int user_id){
        return rentRepository.findByUserId(user_id);
    }

    // Add a new Rent
    public Rent addRent(Rent rent) {
        // Save Rent entity with proper Car and User references
        return rentRepository.save(rent);
    }

    // Update an existing Rent
    public Optional<Rent> updateRent(int id, Rent rentDetails) {
        return rentRepository.findById(id).map(rent -> {
            rent.setPrice(rentDetails.getPrice());
            rent.setRentalDate(rentDetails.getRentalDate());
            rent.setReturnDate(rentDetails.getReturnDate());
            rent.setCar(rentDetails.getCar());
            rent.setUser(rentDetails.getUser());
            return rentRepository.save(rent);
        });
    }

    // Delete a Rent
    public boolean deleteRent(int id) {
        if (rentRepository.existsById(id)) {
            rentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
