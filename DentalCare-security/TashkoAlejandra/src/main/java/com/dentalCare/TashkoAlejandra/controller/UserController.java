package com.dentalCare.TashkoAlejandra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
     public String home() {
        return "<h1> Welcome! <h1>";
    };

    @GetMapping("/user")
    public String homeUser() {
        return "<h1> Welcome! <h1>";
    };

    @GetMapping("/admin")
    public String homeAdmin() {
        return "<h1> Welcome! <h1>";
    };

}
