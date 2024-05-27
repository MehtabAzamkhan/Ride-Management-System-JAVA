/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 * Represents a driver in the VIT Ride Management System.
 */
public class Driver {
    // Attributes
    private String driverID;
    private String name;
    private String licenseNumber;
    private String vehicleInfo;
    private boolean availabilityStatus;
    
    // Constructor
    public Driver(String driverID, String name, String licenseNumber, String vehicleInfo) {
        this.driverID = driverID;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.vehicleInfo = vehicleInfo;
        this.availabilityStatus = true; // Assume driver is available by default
    }
    
    // Getters and Setters
    public String getDriverID() {
        return driverID;
    }
    
    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLicenseNumber() {
        return licenseNumber;
    }
    
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    
    public String getVehicleInfo() {
        return vehicleInfo;
    }
    
    public void setVehicleInfo(String vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }
    
    public boolean isAvailable() {
        return availabilityStatus;
    }
    
    public void setAvailability(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
    
    // Method for registering a driver
    public void register() {
        System.out.println("Driver registered: " + name);
    }
    
    // Method for acknowledging driver removal
    public void remove() {
        System.out.println("Driver removed: " + name);
    }
    
    // Method for displaying driver information
    public void display() {
        System.out.println("DriverID: " + driverID);
        System.out.println("Name: " + name);
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Vehicle Info: " + vehicleInfo);
        System.out.println("Availability: " + (availabilityStatus ? "Available" : "Not Available"));
    }
}
