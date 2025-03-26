package com.example.TimerManager.DTO;

import com.example.TimerManager.Model.CurrentWeekTimer;

public class CurrentWeekTimerDTO {

    private String username;
    private int timeSpentStudying;
    private int numberOfStudySessions;
    private String weekStartDate;
    private String weekEndDate;

    // Default constructor
    public CurrentWeekTimerDTO() {
    }

    // Constructor with all fields
    public CurrentWeekTimerDTO(String username, int timeSpentStudying, int numberOfStudySessions, String weekStartDate, String weekEndDate) {
        this.username = username;
        this.timeSpentStudying = timeSpentStudying;
        this.numberOfStudySessions = numberOfStudySessions;
        this.weekStartDate = weekStartDate;
        this.weekEndDate = weekEndDate;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTimeSpentStudying() {
        return timeSpentStudying;
    }

    public void setTimeSpentStudying(int timeSpentStudying) {
        this.timeSpentStudying = timeSpentStudying;
    }

    public int getNumberOfStudySessions() {
        return numberOfStudySessions;
    }

    public void setNumberOfStudySessions(int numberOfStudySessions) {
        this.numberOfStudySessions = numberOfStudySessions;
    }

    public String getWeekStartDate() {
        return weekStartDate;
    }

    public void setWeekStartDate(String weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    public String getWeekEndDate() {
        return weekEndDate;
    }

    public void setWeekEndDate(String weekEndDate) {
        this.weekEndDate = weekEndDate;
    }

}
