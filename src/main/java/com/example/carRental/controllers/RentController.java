package com.example.carRental.controllers;

import com.example.carRental.models.Rent;
import com.example.carRental.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/rent")
public class RentController {

    @Autowired
    RentService rentService;

    @GetMapping
    public ResponseEntity<List<Rent>> getAllRent(){return ResponseEntity.ok(rentService.getAllRent());}

    @GetMapping("/{user_id}")
    public ResponseEntity<List<Rent>> getUserRent(@PathVariable int user_id){
        List<Rent> userRents = rentService.getUserRents(user_id);
        return ResponseEntity.ok(userRents);
    }
    // Add a new Rent
    @PostMapping
    public ResponseEntity<Rent> addRent(@RequestBody Rent rent) {
        Rent savedRent = rentService.addRent(rent);
        return ResponseEntity.ok(savedRent);
    }

    // Update an existing Rent
    @PutMapping("/{id}")
    public ResponseEntity<Rent> updateRent(@PathVariable int id, @RequestBody Rent rent) {
        Optional<Rent> updatedRent = rentService.updateRent(id, rent);
        return updatedRent.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a Rent
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRent(@PathVariable int id) {
        boolean deleted = rentService.deleteRent(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
