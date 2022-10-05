package com.example.project.controller;

import com.example.project.domain.Role;
import com.example.project.domain.User;
import com.example.project.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "userList";
    }
    @GetMapping("{id}")
    public String userEditForm(@PathVariable Long id, Model model){
     //   model.addAttribute("existingUser", id);
        User userFromDb = userRepo.findUserById(id);
        model.addAttribute("user", userFromDb);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(@ModelAttribute("user") User user){
        userRepo.save(user);

        return "redirect:/user";
    }

}
