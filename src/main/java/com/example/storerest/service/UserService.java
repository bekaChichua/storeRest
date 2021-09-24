package com.example.storerest.service;

import com.example.storerest.entities.users.User;
import com.example.storerest.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> getAllUsers(){
        return userDetailsRepo.findAll();
    }

    public void insertUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsRepo.save(user);
    }

//    public User getUserById(int id){
//        return userDetailsRepo.getById(id);
//    }

}
