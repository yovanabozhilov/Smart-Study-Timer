package com.example.NewProject.Controller;

import com.example.NewProject.Service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timer")
public class TimerController {

    private final TimerService timerService;

    @Autowired
    public TimerController(TimerService timerService) {
        this.timerService = timerService;
    }

    @PostMapping("/save-progress")
    public void saveProgress(@RequestBody TimerData timerData) {
        // Assuming userEmail is passed with the request or obtained from session
        String userEmail = "user@example.com"; // Replace this with actual user email

        timerService.saveProgress(userEmail, timerData.getTimeSpent(), timerData.getProgress());
    }

    public static class TimerData {
        private int timeSpent;
        private int progress;

        public int getTimeSpent() {
            return timeSpent;
        }

        public void setTimeSpent(int timeSpent) {
            this.timeSpent = timeSpent;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }
    }
}
