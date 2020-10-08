package com.dev.med.siboback.controllers;

import com.dev.med.siboback.entities.users.User;
import com.dev.med.siboback.services.UserService;
import com.dev.med.siboback.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class HelloController {

    @Autowired
    UserServiceImpl userService;
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot! med";
    }

    @PostMapping("/add")
    public String addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping("/list")
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
