package com.example.TimerManager.Message;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileMessage {
    private String message;
    private Boolean status;
    private String username;
    private long timeSpentStudying;
    private int numberOfStudySessions;

    private String weekStartDate;
    private String weekEndDate;


    public ProfileMessage() {}

    // Constructor with all fields
    public ProfileMessage(String message, Boolean status, String username, long timeSpentStudying, int numberOfStudySessions , String weekStartDate, String weekEndDate) {
        this.message = message;
        this.status = status;
        this.username = username;
        this.timeSpentStudying = timeSpentStudying;
        this.numberOfStudySessions = numberOfStudySessions;
        this.weekStartDate = weekStartDate;
        this.weekEndDate = weekEndDate;
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

    public long getTimeSpentStudying() {
        return timeSpentStudying;
    }

    public void setTimeSpentStudying(long timeSpentStudying) {
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