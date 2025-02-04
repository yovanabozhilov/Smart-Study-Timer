package com.example.NewProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "TIMERS")
public class Timer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userEmail;
    private int timeSpent;
    private int studyProgress;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public int getStudyProgress() {
        return studyProgress;
    }

    public void setStudyProgress(int studyProgress) {
        this.studyProgress = studyProgress;
    }
}