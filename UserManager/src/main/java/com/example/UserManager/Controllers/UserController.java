package com.example.UserManager.Controllers;

import com.example.UserManager.DTO.LoginDTO;
import com.example.UserManager.Messages.LoginMessage;
import com.example.UserManager.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO,  HttpSession session) {
        LoginMessage loginResponse = userService.loginUser(loginDTO, session);
        return ResponseEntity.ok(loginResponse);
    }




}