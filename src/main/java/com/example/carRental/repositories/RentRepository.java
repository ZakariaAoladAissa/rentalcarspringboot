package com.example.carRental.repositories;

import com.example.carRental.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent,Integer> {
    List<Rent> findByUserId(int userId);
}
