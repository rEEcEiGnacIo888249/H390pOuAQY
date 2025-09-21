// 代码生成时间: 2025-09-21 14:56:04
package com.example.errorlogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class ErrorLoggerSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErrorLoggerSpringBootApplication.class, args);
    }

    @PostMapping("/log")
    public ResponseEntity<String> logError(@RequestBody LogEntry logEntry) {
        // Logic to handle the error log
        // For simplicity, this example just returns the logged message
        return ResponseEntity.ok("Error logged: " + logEntry.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptions(Exception ex) {
        // Log the exception details (e.g., using a logging framework)
        // Return a generic error message to the client
        return ResponseEntity.badRequest().body("An error occurred: " + ex.getMessage());
    }

    // Inner class representing a log entry
    static class LogEntry {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
