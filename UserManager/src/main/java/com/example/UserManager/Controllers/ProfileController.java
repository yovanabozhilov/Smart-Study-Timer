package com.example.UserManager.Controllers;

import com.example.UserManager.DTO.ProfileDTO;

import com.example.UserManager.Messages.ProfileMessage;
import com.example.UserManager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/user")
public class ProfileController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.OPTIONS}, allowedHeaders = "*")
    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(@RequestParam("username") String username) {
        if (username == null) {
            return ResponseEntity.badRequest().body("Username is required");
        }
        ProfileDTO profileDTO = new ProfileDTO(username);
        ProfileMessage profileResponse = userService.showProfile(profileDTO);
        return ResponseEntity.ok(profileResponse);

    }
}
