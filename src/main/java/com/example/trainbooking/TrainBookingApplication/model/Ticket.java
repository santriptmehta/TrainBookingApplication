package com.example.trainbooking.TrainBookingApplication.model;


import jakarta.persistence.Embeddable;

@Embeddable
public class Ticket {
    private String fromLocation;
    private String toLocation;
    private double price;
    private String seat;

    // Getters and setters
    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}