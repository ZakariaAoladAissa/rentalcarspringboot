package com.example.carRental.controllers;

import com.example.carRental.models.Car;
import com.example.carRental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarService carService;
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) {
        return carService.getById(id)
                .map(ResponseEntity::ok) // If car is found, return it with 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // If not found, return 404 Not Found
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.saveCar(car));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable int id,@RequestBody Car car){
        return ResponseEntity.ok(carService.updateCar(id,car));
    }
}
