package com.example.TimerManager.Controllers;

import com.example.TimerManager.DTO.CurrentDayTimerDTO;
import com.example.TimerManager.Service.CurrentDayTimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/timer")
public class CurrentDayTimerController {

    @Autowired
    private CurrentDayTimerService currentDayTimerService;

    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.POST, RequestMethod.OPTIONS}, allowedHeaders = "*")
    @PostMapping("/save-day-timer")
    public ResponseEntity<Map<String, Object>> saveCurrentDayTimer(@RequestBody CurrentDayTimerDTO currentDayTimerDTO, @RequestParam("timestamp") String timestamp)
    {
        LocalDate studyTimestamp = LocalDate.parse(timestamp);
        String responseMessage = currentDayTimerService.saveOrUpdateStudySession(currentDayTimerDTO,studyTimestamp );

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", responseMessage);
        response.put("data", currentDayTimerDTO);

        return ResponseEntity.ok(response);
    }


}

