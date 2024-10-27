package com.example.carRental.repositories;

import com.example.carRental.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Car,Integer> {
    //for repositories they should have the type of the model they work with AND the type of the PK of that model
}
