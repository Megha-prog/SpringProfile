package com.example.springprofileapp.controller;

import com.example.springprofileapp.model.User;
import com.example.springprofileapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import javax.websocket.server.PathParam;
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
    public String PersistUser(@RequestBody List<User> user) {
        return userService.PersistUser(user);
    }

    @GetMapping("/user")
    public List<User> getUser() {
        return userService.getAllUsers();
    }
    @GetMapping("/user/userid")
    private User getUsers(@PathVariable("userid") Integer userid)
    {
        return userService.getUsersById(userid);
    }

}