package com.example.storerest.service;

import com.example.storerest.entities.items.Comment;
import com.example.storerest.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;

    public List<Comment> getComments(Long commentId) {
        return commentRepo.findAllByContent_Id(commentId);
    }
}
