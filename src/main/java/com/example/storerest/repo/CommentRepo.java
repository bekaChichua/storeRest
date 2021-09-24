package com.example.storerest.repo;

import com.example.storerest.entities.items.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    public List<Comment> findAllByContent_Id(Long contentId);
}
