package com.example.storerest.entities.items;

import com.example.storerest.entities.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
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
