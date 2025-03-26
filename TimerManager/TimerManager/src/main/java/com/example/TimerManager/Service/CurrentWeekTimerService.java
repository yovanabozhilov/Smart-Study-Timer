package com.example.TimerManager.Service;

import com.example.TimerManager.Controllers.WeekCalculator;
import com.example.TimerManager.DTO.CurrentWeekTimerDTO;
import com.example.TimerManager.DTO.ProfileDTO;
import com.example.TimerManager.Model.CurrentWeekTimer;
import com.example.TimerManager.Repository.CurrentWeekTimerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TimerManager.Message.ProfileMessage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class CurrentWeekTimerService {

        private final CurrentWeekTimerRepository currentWeekTimerRepository;

        @Autowired
        public CurrentWeekTimerService(CurrentWeekTimerRepository currentWeekTimerRepository) {
            this.currentWeekTimerRepository = currentWeekTimerRepository;
        }

        @Transactional
        public String saveOrUpdateStudySession(CurrentWeekTimerDTO currentWeekTimerDTO, LocalDate timestamp) {
            // Get or create an existing timer
            CurrentWeekTimer existingTimer = getOrCreateExistingTimer(currentWeekTimerDTO.getUsername());

            if (existingTimer != null) {
                // Parse start and end of the week from String to LocalDate
                LocalDate startOfTheWeek = parseDate(existingTimer.getWeekStartDate());
                LocalDate endOfTheWeek = parseDate(existingTimer.getWeekEndDate());

                // Check if the timestamp is within the current week
                if (!timestamp.isBefore(startOfTheWeek) && !timestamp.isAfter(endOfTheWeek)) {
                    // If the timestamp is within the current week, update time spent studying and number of study sessions
                    existingTimer.setTimeSpentStudying(existingTimer.getTimeSpentStudying() + currentWeekTimerDTO.getTimeSpentStudying());
                    existingTimer.setNumberOfStudySessions(existingTimer.getNumberOfStudySessions() + 1);
                } else {
                    // Calculate the new start and end of the week
                    LocalDate startOfTheWeekNew = WeekCalculator.getStartOfWeek(timestamp);
                    LocalDate endOfTheWeekNew = WeekCalculator.getEndOfWeek(timestamp);

                    // Convert LocalDate to String before saving
                    existingTimer.setWeekStartDate(formatDate(startOfTheWeekNew));
                    existingTimer.setWeekEndDate(formatDate(endOfTheWeekNew));
                    existingTimer.setTimeSpentStudying(currentWeekTimerDTO.getTimeSpentStudying()); // Reset for the new week
                    existingTimer.setNumberOfStudySessions(1); // Start with 1 study session for the new week
                }

                // Save the updated timer
                currentWeekTimerRepository.save(existingTimer);
                return currentWeekTimerDTO.getUsername() + " - Timer updated!";
            } else {
                // If no timer exists, create a new one
                LocalDate startOfTheWeekNew = WeekCalculator.getStartOfWeek(timestamp);
                LocalDate endOfTheWeekNew = WeekCalculator.getEndOfWeek(timestamp);

                // Convert LocalDate to String before saving
                existingTimer = new CurrentWeekTimer(
                        currentWeekTimerDTO.getUsername(),
                        currentWeekTimerDTO.getTimeSpentStudying(),
                        1,  // Number of study sessions starts at 1
                        formatDate(startOfTheWeekNew),
                        formatDate(endOfTheWeekNew)
                );

                // Save the newly created timer
                currentWeekTimerRepository.save(existingTimer);
                return currentWeekTimerDTO.getUsername() + " - New timer created!";
            }
        }

        private CurrentWeekTimer getOrCreateExistingTimer(String username) {
            Optional<CurrentWeekTimer> existingTimerOpt = Optional.ofNullable(currentWeekTimerRepository.findByUsername(username));
            return existingTimerOpt.orElse(null);
        }

        private LocalDate parseDate(String date) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Use the correct pattern here
            return LocalDate.parse(date, formatter);
        }

        private String formatDate(LocalDate date) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Use the correct pattern here
            return date.format(formatter);
        }

        public ProfileMessage showProfile(ProfileDTO profileDTO){
        CurrentWeekTimer currentWeekTimer = currentWeekTimerRepository.findByUsername(profileDTO.getUsername());

        if (currentWeekTimer != null) {
            return new ProfileMessage("Login Success", true, currentWeekTimer.getUsername(),currentWeekTimer.getTimeSpentStudying() ,currentWeekTimer.getNumberOfStudySessions(),
                    currentWeekTimer.getWeekStartDate(),currentWeekTimer.getWeekEndDate());
        } else {
            return new ProfileMessage();
        }
        }



}


