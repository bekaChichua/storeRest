package com.example.storerest.service;

import com.example.storerest.entities.users.User;
import com.example.storerest.repo.UserDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class UserService implements UserDetailsService {
    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDetailsRepo.findByUsername(username);
        if (user == null) {
            log.error("Username not found in the database!");
            throw new UsernameNotFoundException("Username not found in the database!");
        }else {
            log.info("User found in the database {}", username);
        }
        log.info(user.getPassword());
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getAuthorities().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        });
        log.info("final user {}", new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities()));
        return user;
    }

    public List<User> getAllUsers(){
        return userDetailsRepo.findAll();
    }

    public void insertUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsRepo.save(user);
    }

}
