package com.example.UserManager.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.UserManager.Model.User;
import com.example.UserManager.Repository.UserRepository;


import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/user")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        Map<String, String> response = new HashMap<>();


        if (userRepository.existsByEmail(user.getEmail())) {
            bindingResult.rejectValue("email", "error.email", "Email is already registered");
        }

        if (bindingResult.hasErrors()) {
            response.put("error", "Validation failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        response.put("message", "Registration successful");
        return ResponseEntity.ok().body(response);
    }
}