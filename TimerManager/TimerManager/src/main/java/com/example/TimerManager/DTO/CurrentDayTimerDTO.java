package com.example.TimerManager.DTO;

public class CurrentDayTimerDTO {

    // Getters and Setters

    private String username;
    private long timeSpentStudying;  // Changed to long to handle larger durations in seconds
    private int numberOfStudySessions;
    private String currentDay;


    // Default constructor
    public CurrentDayTimerDTO() {}

    // Constructor to initialize fields
    public CurrentDayTimerDTO(String username, long timeSpentStudying, int numberOfStudySessions, String currentDay) {
        this.username = username;
        this.timeSpentStudying = timeSpentStudying;
        this.numberOfStudySessions = numberOfStudySessions;
        this.currentDay = currentDay;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTimeSpentStudying(long timeSpentStudying) {
        this.timeSpentStudying = timeSpentStudying;
    }

    public void setNumberOfStudySessions(int numberOfStudySessions) {
        this.numberOfStudySessions = numberOfStudySessions;
    }

    public void setCurrentDay(String currentDay) {
        this.currentDay = currentDay;
    }

    public String getUsername() {
        return username;
    }

    public int getNumberOfStudySessions() {
        return numberOfStudySessions;
    }

    public long getTimeSpentStudying() {
        return timeSpentStudying;
    }

    public String getCurrentDay() {
        return currentDay;
    }
}
