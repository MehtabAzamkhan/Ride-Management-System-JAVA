package com.mycompany.mavenproject1;

/**
 * Represents a user in the VIT Ride Management System.
 */
public class User {
    // Attributes
    private String userID;
    private String name;
    private String contactInfo;
    
    // Constructor
    public User(String userID, String name, String contactInfo) {
        this.userID = userID;
        this.name = name;
        this.contactInfo = contactInfo;
    }
    
    // Getters and Setters
    public String getUserID() {
        return userID;
    }
    
    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getContactInfo() {
        return contactInfo;
    }
    
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    // Method for user registration
    public void register() {
        System.out.println("User registered: " + name);
    }
    
    // Method for acknowledging user removal
    public void remove() {
        System.out.println("User removed: " + name);
    }
    
    // Method for displaying user information
    public void display() {
        System.out.println("UserID: " + userID);
        System.out.println("Name: " + name);
        System.out.println("Contact Info: " + contactInfo);
    }
}
