package com.example.storerest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class StoreRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreRestApplication.class, args);
    }

}
