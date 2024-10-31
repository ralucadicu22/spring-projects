package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @Autowired
    private UserRepository repository;
    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }
}
