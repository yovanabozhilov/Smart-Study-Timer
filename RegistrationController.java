package com.example.NewProject.Controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.NewProject.Model.User;
import com.example.NewProject.Repository.UserRepository;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String createUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (UserRepository.existsByEmail(user.getEmail())) {
            bindingResult.rejectValue("email", "error.email", "Email is already registered");
        }

        if (bindingResult.hasErrors()) {
            return "register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        UserRepository.save(user);

        return "redirect:/login";
    }

}



