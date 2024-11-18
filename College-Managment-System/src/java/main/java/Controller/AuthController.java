package com.example.collegemanagement.controller;

import com.example.collegemanagement.model.User;
import com.example.collegemanagement.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        User user = authService.authenticate(username, password);
        if (user != null) {
            return "Login successful for " + user.getRole();
        }
        return "Invalid credentials";
    }
}
