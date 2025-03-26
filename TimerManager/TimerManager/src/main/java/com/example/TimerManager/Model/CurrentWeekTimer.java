package com.example.TimerManager.Model;

import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;



@Entity
@Table(name = "current_week_timers")
public class CurrentWeekTimer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private int timeSpentStudying;
    private int numberOfStudySessions;

    private String weekStartDate;
    private String weekEndDate;

    public CurrentWeekTimer() {
        // Default constructor
    }

    public CurrentWeekTimer(String username, int timeSpentStudying, int numberOfStudySessions, String weekStartDate, String weekEndDate) {
        this.username = username;
        this.timeSpentStudying = timeSpentStudying;
        this.numberOfStudySessions = numberOfStudySessions;
        this.weekStartDate = weekStartDate;
        this.weekEndDate = weekEndDate;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
