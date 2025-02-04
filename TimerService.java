package com.example.NewProject.Service;

import com.example.NewProject.Model.Timer;
import com.example.NewProject.Repository.TimerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimerService {

    private final TimerRepository timerRepository;

    @Autowired
    public TimerService(TimerRepository timerRepository) {
        this.timerRepository = timerRepository;
    }

    // Save the timer progress for a user
    public void saveProgress(String userEmail, int timeSpent, int studyProgress) {
        Timer timer = timerRepository.findByUserEmail(userEmail);

        if (timer == null) {
            timer = new Timer();
            timer.setUserEmail(userEmail);
            timer.setTimeSpent(timeSpent);
            timer.setStudyProgress(studyProgress);
        } else {
            timer.setTimeSpent(timer.getTimeSpent() + timeSpent);
            timer.setStudyProgress(studyProgress);
        }

        timerRepository.save(timer);
    }
}