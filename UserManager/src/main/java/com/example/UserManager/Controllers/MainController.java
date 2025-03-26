package com.example.UserManager.Controllers;

import com.example.UserManager.Model.User;
import com.example.UserManager.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class MainController {


    private UserRepository repository;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/wellcome")
    public String welcomePage(HttpSession session) {
        return "/wellcome";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model, @SessionAttribute(name = "user", required = false) User user) {
        if (user != null) {
            return "redirect:/login";
        }
        model.addAttribute("user", new User());
        return "register";
    }

}