package com.example.springprofileapp.controller;

import com.example.springprofileapp.model.User;
import com.example.springprofileapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addusers")
    public List<User> PersistUser(@RequestBody List<User> users) {
        return PersistUser(users);
    }

    @GetMapping("/users")
    public List<User> getUser( List<User> users) {
        return userService.getAllUsers();
    }


}