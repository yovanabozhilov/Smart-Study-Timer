package com.example.UserManager.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/user")
public class LogoutController {

    @GetMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout(HttpServletRequest request) {
        // Invalidate the session to log the user out
        request.getSession().invalidate();

        // Clear the Spring Security context
        SecurityContextHolder.clearContext();

        // Create a response object
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Successfully logged out");
        response.put("status", true);

        // Return the JSON response
        return ResponseEntity.ok(response);
    }
}