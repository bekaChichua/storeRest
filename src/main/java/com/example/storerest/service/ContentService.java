package com.example.storerest.service;

import com.example.storerest.entities.items.Content;
import com.example.storerest.entities.users.User;
import com.example.storerest.repo.ContentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    @Autowired
    private UserService userService;

    @Autowired
    private ContentRepo contentRepo;

    public List<Content> getContents(){
       return contentRepo.findAll();
    }
}
