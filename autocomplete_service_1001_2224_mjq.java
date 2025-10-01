// 代码生成时间: 2025-10-01 22:24:38
package com.example.autocompleteservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
public class AutocompleteServiceController {

    private final AutocompleteService autocompleteService;

    @Autowired
    public AutocompleteServiceController(AutocompleteService autocompleteService) {
        this.autocompleteService = autocompleteService;
    }

    @GetMapping("/autocomplete")
    public ResponseEntity<List<String>> getAutocompleteSuggestions(@RequestParam String query) {
        try {
            List<String> suggestions = autocompleteService.getSuggestion(query);
            return ResponseEntity.ok(suggestions);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Validation error: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllOtherExceptions(Exception ex) {
        return ResponseEntity.internalServerError().body("Internal Server Error: " + ex.getMessage());
    }
}

// AutocompleteService.java
package com.example.autocompleteservice.service;

import java.util.List;

public interface AutocompleteService {
    List<String> getSuggestion(String query);
}

// AutocompleteServiceImpl.java
package com.example.autocompleteservice.service.impl;

import com.example.autocompleteservice.service.AutocompleteService;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutocompleteServiceImpl implements AutocompleteService {

    private static final List<String> DATA = Arrays.asList(
        "Apple",
        "Banana",
        "Cherry",
        "Date",
        "Elderberry",
        "Fig"
    );

    @Override
    public List<String> getSuggestion(String query) {
        return DATA.stream()
            .filter(item -> item.toLowerCase().startsWith(query.toLowerCase()))
            .collect(Collectors.toList());
    }
}
