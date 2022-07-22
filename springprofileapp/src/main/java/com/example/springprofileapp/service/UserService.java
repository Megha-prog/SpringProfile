package com.example.springprofileapp.service;

import com.example.springprofileapp.model.User;

import com.example.springprofileapp.reposatory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class   UserService {


    @Autowired
    UserRepository userRepository;



    public List<User>  getAllUsers() {

       return userRepository.findAll();

    }

    public String PersistUser(List<User> users) {
        if (users.size() == 0 || users.isEmpty()) {
            Assert.notNull(users,"user can't be null");
        }
        userRepository.saveAll(users);
        return "Successfully done " + users.size();
    }
}



