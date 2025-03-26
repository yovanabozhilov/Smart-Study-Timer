package com.example.TimerManager.DTO;

import com.example.TimerManager.Model.CurrentWeekTimer;

public class CurrentWeekTimerAssembler {

    // Utility method to convert CurrentWeekTimer to CurrentWeekTimerDTO
    public static CurrentWeekTimerDTO fromModel(CurrentWeekTimer currentWeekTimer) {
        return new CurrentWeekTimerDTO(
                currentWeekTimer.getUsername(),
                currentWeekTimer.getTimeSpentStudying(),
                currentWeekTimer.getNumberOfStudySessions(),
                currentWeekTimer.getWeekStartDate(),
                currentWeekTimer.getWeekEndDate()
        );
    }

    // Utility method to convert CurrentWeekTimerDTO to CurrentWeekTimer
    public static CurrentWeekTimer toModel(CurrentWeekTimerDTO currentWeekTimerDTO) {
        CurrentWeekTimer currentWeekTimer = new CurrentWeekTimer();
        currentWeekTimer.setUsername(currentWeekTimerDTO.getUsername());
        currentWeekTimer.setTimeSpentStudying(currentWeekTimerDTO.getTimeSpentStudying());
        currentWeekTimer.setNumberOfStudySessions(currentWeekTimerDTO.getNumberOfStudySessions());
        currentWeekTimer.setWeekStartDate(currentWeekTimerDTO.getWeekStartDate());
        currentWeekTimer.setWeekEndDate(currentWeekTimerDTO.getWeekEndDate());
        return currentWeekTimer;
    }
}

