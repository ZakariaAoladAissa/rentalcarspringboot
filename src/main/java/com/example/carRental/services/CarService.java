package com.example.carRental.services;

import com.example.carRental.models.Car;
import com.example.carRental.repositories.CarsRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Car updateCar(int id, Car updatedCar){
        //orElseThrow unwraps the Optional thingy
        Car car = carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("This Car Does Not Exists!"));

        car.setModel(updatedCar.getModel());
        car.setPhoto(updatedCar.getPhoto());
        car.setFuel_type(updatedCar.getFuel_type());
        car.setPrice(updatedCar.getPrice());
        car.setGearbox(updatedCar.getGearbox());
        car.setAvailable(updatedCar.isAvailable());

        return carRepository.save(car);
    }

    // Delete a Car
    public boolean deleteCar(int id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
