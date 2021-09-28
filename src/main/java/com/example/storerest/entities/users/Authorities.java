package com.example.storerest.entities.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
public class Authorities implements GrantedAuthority {

    @Id
    private long id;
    private String Authority = "USER";
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_authority")
    private User user;

    @Override
    public String getAuthority() {
        return Authority;
    }
}
