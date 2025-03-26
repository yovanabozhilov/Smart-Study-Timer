package com.example.UserManager.Messages;

public class LoginMessage {
    private String message;
    private Boolean status;
    private String username;

    // Default constructor
    public LoginMessage() {}

    // Constructor with message, status, and token
    public LoginMessage(String message, Boolean status, String username) {
        this.message = message;
        this.status = status;
        this.username = username;
    }

    // Getters and setters for message, status, and token
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
}
