package com.example.UserManager.Messages;

public class ProfileMessage {
    private String message;
    private Boolean status;
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    // Default constructor
    public ProfileMessage() {}

    // Constructor with all fields
    public ProfileMessage(String message, Boolean status, String username, String firstName, String lastName, String email) {
        this.message = message;
        this.status = status;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters and setters for message, status, and user profile fields
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
