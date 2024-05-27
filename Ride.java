package com.mycompany.mavenproject1;
public class Ride {
    // Attributes
    private int rideID;
    private String userID;
    private String driverID;
    private String pickupLocation;
    private String destination;
    private String status; // New attribute for ride status

    // Constructor
    public Ride(int rideID, String userID, String driverID, String pickupLocation, String destination, String status) {
        this.rideID = rideID;
        this.userID = userID;
        this.driverID = driverID;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.status = status; // Initialize status
    }

    // Getters and Setters (including for status)
    public int getRideID() {
        return rideID;
    }

    public void setRideID(int rideID) {
        this.rideID = rideID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Override toString method for better printing
    @Override
    public String toString() {
        return "Ride ID: " + rideID + ", User ID: " + userID + ", Driver ID: " + driverID +
                ", Pickup Location: " + pickupLocation + ", Destination: " + destination +
                ", Status: " + status;
    }
}
