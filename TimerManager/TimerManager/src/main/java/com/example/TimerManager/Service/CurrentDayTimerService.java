package com.example.TimerManager.Service;

import com.example.TimerManager.DTO.CurrentDayTimerDTO;
import com.example.TimerManager.DTO.ProfileDTO;
import com.example.TimerManager.Message.ProfileMessage2;
import com.example.TimerManager.Model.CurrentDayTimer;
import com.example.TimerManager.Repository.CurrentDayTimerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class CurrentDayTimerService {

    @Autowired
    private final CurrentDayTimerRepository currentDayTimerRepository;

    public CurrentDayTimerService(CurrentDayTimerRepository currentDayTimerRepository) {
        this.currentDayTimerRepository = currentDayTimerRepository;
    }

    @Transactional
    public String saveOrUpdateStudySession(CurrentDayTimerDTO currentDayTimerDTO, LocalDate timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedTimestamp = timestamp.format(formatter);

        CurrentDayTimer existingTimer = getOrCreateExistingTimer(currentDayTimerDTO.getUsername(), formattedTimestamp);

        if (existingTimer.getCurrentDay().equals(formattedTimestamp)) {
            existingTimer.setTimeSpentStudying(existingTimer.getTimeSpentStudying() + currentDayTimerDTO.getTimeSpentStudying());
            existingTimer.setNumberOfStudySessions(existingTimer.getNumberOfStudySessions() + 1);
        } else {
            existingTimer.setCurrentDay(formattedTimestamp);
            existingTimer.setTimeSpentStudying(currentDayTimerDTO.getTimeSpentStudying());
            existingTimer.setNumberOfStudySessions(1); // Reset to 1 since this is the first session for the new day
        }

        // Save the updated or new timer
        currentDayTimerRepository.save(existingTimer);

        return currentDayTimerDTO.getUsername();
    }


    private CurrentDayTimer getOrCreateExistingTimer(String username, String formattedTimestamp) {
        Optional<CurrentDayTimer> existingTimerOpt = Optional.ofNullable(currentDayTimerRepository.findByUsername(username));

        if (existingTimerOpt.isPresent()) {
            return existingTimerOpt.get();
        } else {
            CurrentDayTimer newTimer = new CurrentDayTimer(
                    username,
                    0,
                    0,
                    formattedTimestamp
            );
            return newTimer;
        }
    }

    public ProfileMessage2 showProfile2(ProfileDTO profileDTO){
        CurrentDayTimer currentDayTimer = currentDayTimerRepository.findByUsername(profileDTO.getUsername());

        if (currentDayTimer != null) {
            return new ProfileMessage2("Login Success", true, currentDayTimer.getUsername(),currentDayTimer.getTimeSpentStudying() ,
                    currentDayTimer.getNumberOfStudySessions(), currentDayTimer.getCurrentDay());
        } else {
            return new ProfileMessage2();
        }
    }
}

