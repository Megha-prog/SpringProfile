package com.example.springprofileapp.service;

import com.example.springprofileapp.model.User;

import com.example.springprofileapp.reposatory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class   UserService {


    @Autowired
    UserRepository userRepository;


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users1 -> users.add(users1));
        return users;
    }

    public String PersistUser(List<User> users) {
        if (users.size() == 0 || users.isEmpty()) {
            Assert.notNull(users, "user can't be null");
        }
        userRepository.saveAll(users);
        return "Successfully done " + users.size();
    }

    public User getUsersById(Integer userid) {
        Optional<User> userData = userRepository.findById(userid);
        if (userData.isEmpty()) {
            Assert.notNull(userid, "user can't be null");
        }
        return userRepository.findById(userid).get();
    }
    }




