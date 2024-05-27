package com.mycompany.mavenproject1;

import java.util.Scanner;

public class Mavenproject1 {

    public static void main(String[] args) {
        displayMenu();
    }

    // Method to display the menu and handle user input
    public static void displayMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            RideManager rideManager = new RideManager();

            boolean exit = false;
            while (!exit) {
                System.out.println("\nVIT Ride Management System");
                System.out.println("1. Register User");
                System.out.println("2. Remove User");
                System.out.println("3. Display All Users");
                System.out.println("4. Register Driver");
                System.out.println("5. Remove Driver");
                System.out.println("6. Display All Drivers");
                System.out.println("7. Request Ride");
                System.out.println("8. Allocate Driver to Ride");
                System.out.println("9. Display Ongoing Rides");
                System.out.println("10. Display Ride History");
                System.out.println("11. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                handleUserInput(choice, scanner, rideManager);

                if (choice == 11) {
                    exit = true;
                }
            }
        }
    }

    // Method to handle user input based on the choice
    public static void handleUserInput(int choice, Scanner scanner, RideManager rideManager) {
        switch (choice) {
            case 1 -> {
                System.out.print("Enter userID: ");
                String userID = scanner.nextLine();
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter contact information: ");
                String contactInfo = scanner.nextLine();
                User user = new User(userID, name, contactInfo);
                rideManager.registerUser(user);
            }
            case 2 -> {
                System.out.print("Enter userID to remove: ");
                String userIDToRemove = scanner.nextLine();
                rideManager.removeUser(userIDToRemove);
                System.out.println("User removed.");
            }
            case 3 -> rideManager.displayAllUsers();
            case 4 -> {
                System.out.print("Enter driverID: ");
                String driverID = scanner.nextLine();
                System.out.print("Enter name: ");
                String driverName = scanner.nextLine();
                System.out.print("Enter license number: ");
                String licenseNumber = scanner.nextLine();
                System.out.print("Enter vehicle details: ");
                String vehicleDetails = scanner.nextLine();
                Driver driver = new Driver(driverID, driverName, licenseNumber, vehicleDetails);
                rideManager.registerDriver(driver);
            }
            case 5 -> {
                System.out.print("Enter driverID to remove: ");
                String driverIDToRemove = scanner.nextLine();
                rideManager.removeDriver(driverIDToRemove);
                System.out.println("Driver removed.");
            }
            case 6 -> rideManager.displayAllDrivers();
            case 7 -> {
    System.out.print("Enter userID: ");
    String userID = scanner.nextLine();
    System.out.print("Enter pickup location: ");
    String pickupLocation = scanner.nextLine();
    System.out.print("Enter destination: ");
    String destination = scanner.nextLine();
    rideManager.requestRide(userID, pickupLocation, destination);
            }
  case 8 -> {
    System.out.print("Enter Driver ID: ");
    String driverID = scanner.nextLine();
    System.out.print("Enter User ID: ");
    String userID = scanner.nextLine();
    System.out.print("Enter Ride ID: ");
    int rideID = scanner.nextInt();
    scanner.nextLine(); // Consume newline

}

case 9 -> {
    rideManager.displayOngoingRides();
}
case 10 -> {
    rideManager.displayRideHistory();
}
           
            default -> System.out.println("Invalid choice. Please enter a number between 1 and 11.");
        }
    }
}
