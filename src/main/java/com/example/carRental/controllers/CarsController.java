package com.example.carRental.controllers;

import com.example.carRental.models.Car;
import com.example.carRental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarService carService;
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.ok(carService.getAllCars());
    }
}
