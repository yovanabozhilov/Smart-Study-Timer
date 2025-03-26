package com.example.UserManager.Service;

import com.example.UserManager.DTO.LoginDTO;
import com.example.UserManager.DTO.ProfileDTO;
import com.example.UserManager.Messages.LoginMessage;
import com.example.UserManager.Messages.ProfileMessage;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.UserManager.Model.User;
import com.example.UserManager.Repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{

    private UserRepository userRepo;

    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);  // Find the user by username
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);  // Throw exception if not found
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public ProfileMessage showProfile(ProfileDTO profileDTO){
        User user = userRepo.findByUsername(profileDTO.getUsername());

        if (user != null) {
            return new ProfileMessage("Login Success", true, user.getUsername(),user.getFirstName() ,user.getLastName(),user.getEmail());
        } else {
            return new ProfileMessage("Username does not exist", false, null,null,null,null);
        }
    }

    public LoginMessage loginUser(LoginDTO loginDTO, HttpSession session) {
//        String msg = "";

        User user = userRepo.findByUsername(loginDTO.getUsername());

        if (user != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();

            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if (isPwdRight) {

                session.setAttribute("username", user.getUsername());
                return new LoginMessage("Login Success", true, user.getUsername());

            } else {
                return new LoginMessage("Password does not match", false,  null);
            }
        } else {
            return new LoginMessage("Username does not exist", false, null);
        }
    }


}