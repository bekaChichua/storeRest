package com.example.storerest.controllers;

import com.example.storerest.entities.items.Content;
import com.example.storerest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000/")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping("/post")
    public List<Content> getUserContent(){
        return contentService.getContents();
    }
}
