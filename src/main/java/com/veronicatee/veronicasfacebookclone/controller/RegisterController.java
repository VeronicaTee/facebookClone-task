package com.veronicatee.veronicasfacebookclone.controller;

import com.veronicatee.veronicasfacebookclone.model.User;
import com.veronicatee.veronicasfacebookclone.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class RegisterController {
    UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("invalid", null);
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String signup(@Valid User user, Model model) {
        User user1 = userService.getUserByEmail(user.getEmail());
        if (user1 != null) {
            //error message if email provided is already registered
            model.addAttribute("invalid", "User already exists");
            return "register";
        }

        userService.addUser(user);
        //successful registration message
        model.addAttribute("newregistration", "Registration successful!");
        return "login";
    }
}