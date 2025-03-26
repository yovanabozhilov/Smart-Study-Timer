package com.example.TimerManager.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "current_day_timers")
public class CurrentDayTimer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  // Column in the database (primary key)
    private Long id;

    @Column(name = "username")  // Column in the database
    private String username;

    @Column(name = "time_spent_studying")  // Column in the database
    private long timeSpentStudying;  // Store in seconds

    @Column(name = "number_of_study_sessions")  // Column in the database
    private int numberOfStudySessions;

    @Column(name = "current_day")  // Column in the database
    private String currentDay;

    public CurrentDayTimer() {}

    public CurrentDayTimer(String username, long timeSpentStudying, int numberOfStudySessions, String currentDay) {
        this.username = username;
        this.timeSpentStudying = timeSpentStudying;
        this.numberOfStudySessions = numberOfStudySessions;
        this.currentDay = currentDay;
    }

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

    public String getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(String currentDay) {
        this.currentDay = currentDay;
    }
}

