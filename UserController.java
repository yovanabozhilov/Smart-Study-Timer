package com.example.NewProject.Controller;

import jakarta.servlet.http.HttpSession;
import com.example.NewProject.Model.User;
import com.example.NewProject.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model, @SessionAttribute(name = "user", required = false) User user) {
        if (user != null) {
            return "redirect:/home";
        }
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        try {
            userService.registerUser(user);  // Hashing the password before saving
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }

        return "redirect:/login";
    }


    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        boolean isAuthenticated = userService.authenticateUser(email, password);

        if (isAuthenticated) {
            session.setAttribute("user", email);
            return "redirect:/wellcome";
        } else {
            return "redirect:/login";
        }
    }

}
