package com.example.project;

import com.example.project.domain.User;
import com.example.project.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
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
    public String add(@ModelAttribute("user") User user, Model model){
        userRepo.save(user);

        Iterable<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "main";
    }
/* @PostMapping()
 public @ResponseBody String addNewUser (@RequestParam(name="email", required=false, defaultValue="email") String email,
                                         @RequestParam(name="login", required=false, defaultValue="login") String login,Model model) {
     // @ResponseBody means the returned String is the response, not a view name
     // @RequestParam means it is a parameter from the GET or POST request
     User n = new User();
     n.setLogin(login);
     n.setEmail(email);
     userRepo.save(n);
     return "Saved";
 }*/

}
