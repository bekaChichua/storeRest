package com.example.storerest.controllers;

import com.example.storerest.entities.items.Comment;
import com.example.storerest.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user/post")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/{commentId}")
    public List<Comment>getComments(@PathVariable Long commentId){
        return commentService.getComments(commentId);
    }
}
