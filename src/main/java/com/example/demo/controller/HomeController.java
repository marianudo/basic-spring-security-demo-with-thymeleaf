package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/data")
    @ResponseBody
    public String userData() {
        return "User-specific data";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/data")
    @ResponseBody
    public String adminData() {
        return "Admin-specific data";
    }

    @GetMapping("/me")
    @ResponseBody
    public UserDetails getLoggedInUserProfile(@AuthenticationPrincipal UserDetails user) {
        return user;
    }
}
