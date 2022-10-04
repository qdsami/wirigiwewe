package com.example.project.controller;

import com.example.project.domain.User;
import com.example.project.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "")String filter,
                       Model model, @ModelAttribute("user") User user) {
        Iterable<User> users;

        if (filter != null && !filter.isEmpty()) {
            users = userRepo.findByCity(filter);
        } else {
            users = userRepo.findAll();
        }
        model.addAttribute("users", users);
        model.addAttribute("filter", filter);
        return "main";
    }
}
