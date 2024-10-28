package com.example.carRental.services;

import com.example.carRental.models.Car;
import com.example.carRental.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarsRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    //Optional because result might be null
    public Optional<Car> getById(int id){
        return carRepository.findById(id);
    }

    public Car saveCar(Car car){
       return carRepository.save(car);
    }
}
