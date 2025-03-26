package com.example.TimerManager.Controllers;

import com.example.TimerManager.DTO.ProfileDTO;
import com.example.TimerManager.Message.ProfileMessage;
import com.example.TimerManager.Message.ProfileMessage2;
import com.example.TimerManager.Service.CurrentDayTimerService;
import com.example.TimerManager.Service.CurrentWeekTimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/timer")
public class ProfileController {

    @Autowired
    private CurrentWeekTimerService currentWeekTimerService;
    @Autowired
    private CurrentDayTimerService currentDayTimerService;

    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.OPTIONS}, allowedHeaders = "*")
    @GetMapping("/profile-current-week")
    public ResponseEntity<?> getUserProfile(@RequestParam("username") String username) {
        if (username == null) {
            return ResponseEntity.badRequest().body("Username is required");
        }

        ProfileDTO profileDTO = new ProfileDTO(username);
        ProfileMessage profileResponse = currentWeekTimerService.showProfile(profileDTO);
        System.out.println("ProfileResponse: " + profileResponse);

        return ResponseEntity.ok(profileResponse);
    }

    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.OPTIONS}, allowedHeaders = "*")
    @GetMapping("/profile-current-day")
    public ResponseEntity<?> getUserProfile2(@RequestParam("username") String username) {
        if (username == null) {
            return ResponseEntity.badRequest().body("Username is required");
        }

        ProfileDTO profileDTO = new ProfileDTO(username);
        ProfileMessage2 profileResponse = currentDayTimerService.showProfile2(profileDTO);
        System.out.println("ProfileResponse: " + profileResponse);

        return ResponseEntity.ok(profileResponse);
    }
}