package com.example.carRental.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String photo;
    private String model;
    private String fuel_type;
    private int price;
    private String gearbox;
    private boolean available;

    @OneToMany(mappedBy = "car")
    private List<Rent> rents;

    public Car() {
    }
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", available=" + available +
                ", brand='" + brand + '\'' +
                ", fuelType='" + fuel_type + '\'' +
                ", gearbox='" + gearbox + '\'' +
                ", model='" + model + '\'' +
                ", photo='" + photo + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
