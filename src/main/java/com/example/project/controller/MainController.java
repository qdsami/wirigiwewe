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
    public String main(Model model, @ModelAttribute("user") User user) {
        Iterable<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "main";
    }

    @PostMapping("/main")
    public String add(Model model) {
        Iterable<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model) {
        Iterable<User> users;
        if (filter != null && !filter.isEmpty()) {
            users = userRepo.findByCity(filter);
        } else {
            users = userRepo.findAll();
        }
        model.addAttribute("users", users);
        return "main";
    }

}
