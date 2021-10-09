package com.example.storerest.entities.items;

import com.example.storerest.entities.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date = new Date();
    private String text;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "content_comment")
    private Content content;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_comment")
    private User user;
}
