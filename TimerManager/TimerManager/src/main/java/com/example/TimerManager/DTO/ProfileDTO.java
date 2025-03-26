package com.example.TimerManager.DTO;

public class ProfileDTO {
    private String username;

    // Constructor, getters, and setters
    public ProfileDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}