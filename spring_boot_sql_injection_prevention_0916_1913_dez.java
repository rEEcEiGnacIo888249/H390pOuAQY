// 代码生成时间: 2025-09-16 19:13:30
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.NoSuchElementException;

@SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }
}

@RestController
class ApiController extends ResponseEntityExceptionHandler {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam("username") String username) {
        // 使用命名参数和类型参数防止SQL注入
        String queryStr = "SELECT u FROM User u WHERE u.username = :username";
        Query query = entityManager.createQuery(queryStr, User.class)
                .setParameter("username", username);
        try {
            return query.getResultList();
        } catch (Exception e) {
            throw new ApiException("Error occurred during search", e);
        }
    }
}

class User {
    private Long id;
    private String username;
    // getters and setters
}

class ApiException extends RuntimeException {
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
