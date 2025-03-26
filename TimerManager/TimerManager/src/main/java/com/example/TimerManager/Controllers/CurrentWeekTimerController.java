package com.example.TimerManager.Controllers;

import com.example.TimerManager.DTO.CurrentWeekTimerDTO;
import com.example.TimerManager.Service.CurrentWeekTimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/timer")
public class CurrentWeekTimerController {

    @Autowired
    private CurrentWeekTimerService currentWeekTimerService;

    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.POST, RequestMethod.OPTIONS}, allowedHeaders = "*")
    @PostMapping("/save-week-timer")
    public ResponseEntity<Map<String, Object>> saveCurrentWeekTimer(@RequestBody CurrentWeekTimerDTO currentWeekTimerDTO, @RequestParam("timestamp") String timestamp)
    {
        LocalDate studyTimestamp = LocalDate.parse(timestamp);
        String responseMessage = currentWeekTimerService.saveOrUpdateStudySession(currentWeekTimerDTO,studyTimestamp );

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", responseMessage);
        response.put("data", currentWeekTimerDTO);

        return ResponseEntity.ok(response);
    }
}

