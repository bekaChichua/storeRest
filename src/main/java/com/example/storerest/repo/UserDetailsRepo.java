package com.example.storerest.repo;

import com.example.storerest.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
