package com.example.carRental.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="rents")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int price;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate rentalDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate returnDate;

    //this annotation is used if you want to map the entire objeect , you still onmy store the id on the table ???
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", price=" + price +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", carId=" + car.toString() +
                ", userId=" + (user != null ? user.getId() : "null") +
                '}';
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rent() {
    }

    public Rent(int id, int price, LocalDate rentalDate, LocalDate returnDate, Car car, User user) {
        this.id = id;
        this.price = price;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.car = car;
        this.user = user;
    }
}
