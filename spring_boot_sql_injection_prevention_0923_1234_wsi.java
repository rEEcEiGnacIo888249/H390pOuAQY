// 代码生成时间: 2025-09-23 12:34:13
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.NoSuchElementException;

@SpringBootApplication
@RestController
public class SpringBootApplication {

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

    @GetMapping("/secure-query")
    public ResponseEntity<List<User>> retrieveUser(@RequestParam String username) {
        try {
            String query = "SELECT u FROM User u WHERE u.username = :username";
            TypedQuery<User> queryResult = entityManager.createQuery(query, User.class).setParameter("username", username);
            return ResponseEntity.ok(queryResult.getResultList());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(NoSuchElementException ex) {
        return ResponseEntity.badRequest().body("Invalid Username");
    }
}

class User {
    private Long id;
    private String username;
    // Getters and setters
}

// Note: This code is a simplified example and does not include all necessary
// Spring Boot configurations and additional security measures.
