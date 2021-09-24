package com.example.storerest.repo;

import com.example.storerest.entities.items.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepo extends JpaRepository<Content, Long> {
}
