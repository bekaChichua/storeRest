package com.example.storerest.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.storerest.entities.items.Content;
import com.example.storerest.entities.users.User;
import com.example.storerest.repo.ContentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Slf4j
@Service
public class ContentService {
    @Autowired
    private UserService userService;

    @Autowired
    private ContentRepo contentRepo;

    public Content getContentById(Long id){
        return contentRepo.getById(id);
    }

    public List<Content> getContents(){
       return contentRepo.findAll();
    }

    public void insertContent(HttpServletRequest request, HttpServletResponse response, Content content) {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        String token = authorizationHeader.substring("Bearer ".length());
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String username = decodedJWT.getSubject();
        User user = (User)userService.loadUserByUsername(username);
        log.info("This user is {}", user.getUsername());
        content.setUser(user);
        user.getContent().add(content);
        userService.insertUser(user);
    }
}
