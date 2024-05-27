package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Manages users, drivers, ongoing rides, and ride history in the VIT Ride Management System.
 */
public class RideManager {
    // Attributes
    private final List<User> users;
    private final List<Driver> drivers;
  private final List<Ride> ongoingRides; // New attribute for ongoing rides
  private final List<Ride> assignedRides;
  private final Timer timer;
   private final List<Ride> rideHistory;
  

    // Constructor
    public RideManager() {
        this.users = new ArrayList<>();
        this.drivers = new ArrayList<>();
      this.ongoingRides = new ArrayList<>();
      this.assignedRides = new ArrayList<>();
      this.timer = new Timer();
       this.rideHistory = new ArrayList<>();
    }
    
    // Methods for managing users
    public void registerUser(User user) {
        users.add(user);
        user.register();
    }
    
    public void removeUser(String userID) {
        users.removeIf(user -> user.getUserID().equals(userID));
    }
    
    public void displayAllUsers() {
        System.out.println("Registered Users:");
        for (User user : users) {
            user.display();
        }
    }
    

    // Methods for managing drivers
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        driver.register();
    }
    
    public void removeDriver(String driverID) {
        drivers.removeIf(driver -> driver.getDriverID().equals(driverID));
    }
    
    public void displayAllDrivers() {
        System.out.println("Registered Drivers:");
        for (Driver driver : drivers) {
            driver.display();
        }
    }
    
    
    
    // Method to request a ride
public void requestRide(String userID, String pickupLocation, String destination) {
    // Create a new ride instance with a unique ID (you can implement this logic)
    int rideID = generateUniqueRideID(); // Implement this method to generate a unique ride ID
    String driverID = findAvailableDriver(); // Implement this method to find an available driver
    Ride ride = new Ride(rideID, userID, driverID, pickupLocation, destination, "Requested");
    // Add the ride to the list of ongoing rides or pending requests (you can decide based on your system design)
    addRide(ride); // Implement this method to add the ride to a list
    System.out.println("Ride requested successfully.");
}

private int generateUniqueRideID() {
    Random rand = new Random();
    int firstNumber = rand.nextInt(100); // Generates a random number between 0 and 99
    int secondNumber = rand.nextInt(100); // Generates another random number between 0 and 99
    // Concatenate the two numbers to form the unique ID
    String uniqueIDString = String.format("%02d%02d", firstNumber, secondNumber);
    System.out.println("Generated Unique Ride ID String: " + uniqueIDString);
    return Integer.parseInt(uniqueIDString);
   
}

private String findAvailableDriver() {
    for (Driver driver : drivers) {
        if (driver.isAvailable()) {
            return driver.getDriverID();
        }
    }
    return ""; // If no available driver is found
}

 // Method to add the ride to a list of ongoing rides
    private void addRide(Ride ride) {
        ongoingRides.add(ride);
        System.out.println("Ride added to ongoing rides.");
    }

    
    
public boolean allocateDriverToRide(String driverID, String userID, int rideID) {
    // Find the ride in ongoing rides list
    Ride allocatedRide = null;
    for (Ride ride : ongoingRides) {
        if (ride.getRideID() == rideID) {
            allocatedRide = ride;
            break;
        }
    }

    // Check if ride is found
    if (allocatedRide != null) {
        // Find the driver in the list of available drivers
        Driver allocatedDriver = null;
        for (Driver driver : drivers) {
            if (driver.getDriverID().equals(driverID)) {
                allocatedDriver = driver;
                break;
            }
        }

        // Check if driver is found
        if (allocatedDriver != null) {
            // Assign the driver to the ride
            allocatedRide.setDriverID(allocatedDriver.getDriverID());
            allocatedDriver.setAvailability(false); // Set driver as unavailable

            // Start a timer to mark the ride as completed after 2 minutes
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    markRideAsCompleted(rideID);
                }
            }, 2 * 60 * 1000); // 2 minutes in milliseconds

            // Update status to "On its way"
            allocatedRide.setStatus("On its way");

            // Remove the driver from the list of available drivers
            removeDriver(driverID);

            System.out.println("Driver allocated to ride successfully.");
            return true; // Allocation successful
        } else {
            System.out.println("Driver not found.");
        }
    } else {
        System.out.println("Ride not found.");
    }
    return false; // Allocation failed
}

    // Method to mark a ride as completed
    private void markRideAsCompleted(int rideID) {
        for (Ride ride : ongoingRides) {
            if (ride.getRideID() == rideID) {
                ride.setStatus("Completed");
                rideHistory.add(ride); // Move the ride to ride history
                ongoingRides.remove(ride); // Remove the ride from ongoing rides
                break;
            }
        }
    }

    // Method to display ongoing rides
    public void displayOngoingRides() {
        System.out.println("Ongoing Rides:");
        for (Ride ride : ongoingRides) {
            System.out.println(ride);
        }
    }

    // Method to display ride history
    public void displayRideHistory() {
        System.out.println("Ride History:");
        for (Ride ride : rideHistory) {
            System.out.println(ride);
        }
    }
// Method to display assigned rides
public void displayAssignedRides() {
    System.out.println("Assigned Rides:");
    for (Ride ride : assignedRides) {
        System.out.println(ride); // Assuming Ride class overrides the toString method
    }
}

    
    
}
