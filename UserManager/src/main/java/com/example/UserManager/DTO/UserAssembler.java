package com.example.UserManager.DTO;

import com.example.UserManager.Model.User;

import java.util.ArrayList;

public class UserAssembler {

    // Convert User Model to UserDTO
    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        return new UserDTO(user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(), new ArrayList<>());
    }

    // Convert UserDTO to User Model (if needed)
    public static User toModel(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        return new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getUsername(), userDTO.getEmail(), ""); // Password is blank here, it's not in DTO
    }
}