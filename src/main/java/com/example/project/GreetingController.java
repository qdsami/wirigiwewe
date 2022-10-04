package com.example.project;

import com.example.project.domain.User;
import com.example.project.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Model model, @ModelAttribute("user") User user) {
        Iterable<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "main";
    }

    @PostMapping
    public String add(@ModelAttribute("user") User user, Model model) {
        userRepo.save(user);

        Iterable<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model, @ModelAttribute("user") User user) {
        Iterable<User> users;
        if (filter != null && filter.isEmpty()) {
            users = userRepo.findByCity(filter);
        } else {
            users = userRepo.findAll();
        }

        model.addAttribute("users", users);
        return "main";
    }

}
