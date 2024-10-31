package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Autowired
    private UserRepository repository;
    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }
    @GetMapping("/register")
    public String viewRegisterPage(Model model){
        model.addAttribute("user",new Users());
        return "registration_form";
    }
    @PostMapping("/process_register")
    public String successfulRegistration(Users user){
        BCryptPasswordEncoder passwordEncode=new BCryptPasswordEncoder();
        String encodedPassword=passwordEncode.encode(user.getPassword());
        repository.save(user);
        return "successful";
    }
}
