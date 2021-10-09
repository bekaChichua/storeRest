package com.example.storerest.controllers;

import com.example.storerest.entities.items.Comment;
import com.example.storerest.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user/post")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/{contentId}")
    public List<Comment>getComments(@PathVariable Long contentId){
        return commentService.getComments(contentId);
    }
    @PostMapping("/{contentId}")
    public void addComment(HttpServletRequest request, @PathVariable Long contentId, @RequestBody Comment comment){
        commentService.insertComment(request, contentId, comment);
    }

    @MessageMapping("/comments/{contentId}")
    @SendTo("/topic/{contentId}")
    public Comment PostComment(@DestinationVariable Long contentId, @Payload Comment comment){
        log.info("Comment {} ", comment);
        commentService.stompComment(contentId, comment);
        return comment;
    }



}
