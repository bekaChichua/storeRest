package com.example.storerest.entities.items;

import javax.persistence.*;

import com.example.storerest.entities.items.Comment;
import com.example.storerest.entities.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Content {
    @Id
    private long id;
    private Date date = new Date();
    private String body;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "content")
    private List<Comment> comment;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_content")
    private User user;

}
