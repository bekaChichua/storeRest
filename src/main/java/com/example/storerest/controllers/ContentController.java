package com.example.storerest.controllers;

import com.example.storerest.entities.items.Content;
import com.example.storerest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping("/post")
    public List<Content> getUserContent(){
        return contentService.getContents();
    }

    @PostMapping("/post")
    public void insertContent(HttpServletRequest request, HttpServletResponse response, @RequestBody Content content){
        contentService.insertContent(request, response, content);
    }
}
