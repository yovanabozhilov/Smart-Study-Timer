package com.example.TimerManager.DTO;

import com.example.TimerManager.Model.CurrentDayTimer;

public class CurrentDayTimerAssembler {

    // Utility method to convert CurrentDayTimer to CurrentDayTimerDTO
    public static CurrentDayTimerDTO fromModel(CurrentDayTimer currentDayTimer) {
        return new CurrentDayTimerDTO(
                currentDayTimer.getUsername(),
                currentDayTimer.getTimeSpentStudying(),
                currentDayTimer.getNumberOfStudySessions(),
                currentDayTimer.getCurrentDay() // Removed the extra comma here
        );
    }

    // Utility method to convert CurrentDayTimerDTO to CurrentDayTimer
    public static CurrentDayTimer toModel(CurrentDayTimerDTO currentDayTimerDTO) {
        CurrentDayTimer currentDayTimer = new CurrentDayTimer();
        currentDayTimer.setUsername(currentDayTimerDTO.getUsername());
        currentDayTimer.setTimeSpentStudying(currentDayTimerDTO.getTimeSpentStudying());
        currentDayTimer.setNumberOfStudySessions(currentDayTimerDTO.getNumberOfStudySessions());
        currentDayTimer.setCurrentDay(currentDayTimerDTO.getCurrentDay());
        return currentDayTimer;
    }
}


