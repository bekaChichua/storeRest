package com.example.storerest.controllers;

import com.example.storerest.entities.users.User;
import com.example.storerest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }

}
