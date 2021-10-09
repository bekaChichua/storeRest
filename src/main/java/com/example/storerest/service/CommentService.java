package com.example.storerest.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.storerest.entities.items.Comment;
import com.example.storerest.entities.items.Content;
import com.example.storerest.entities.users.User;
import com.example.storerest.repo.CommentRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
@AllArgsConstructor
public class CommentService {
    CommentRepo commentRepo;
    UserService userService;
    ContentService contentService;

    public List<Comment> getComments(Long contentId) {
        return commentRepo.findAllByContent_Id(contentId);
    }

    public  void insertComment(HttpServletRequest request, Long contentId, Comment comment){
        Content content = contentService.getContentById(contentId);

        String authorizationHeader = request.getHeader(AUTHORIZATION);
        String token = authorizationHeader.substring("Bearer ".length());
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String username = decodedJWT.getSubject();
        User user = (User)userService.loadUserByUsername(username);

        comment.setUser(user);
        comment.setContent(content);
        commentRepo.save(comment);
    }

    public void stompComment(Long contentId, Comment comment) {
        comment.setContent(contentService.getContentById(contentId));
        commentRepo.save(comment);
    }
}
