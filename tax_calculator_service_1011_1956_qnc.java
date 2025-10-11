// 代码生成时间: 2025-10-11 19:56:35
package com.example.taxcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class TaxCalculatorService {

    public static void main(String[] args) {
        SpringApplication.run(TaxCalculatorService.class, args);
    }

    // 计算税务的API
    @GetMapping("/calculate-tax")
    public ResponseEntity<Double> calculateTax(@RequestParam("income") Double income) {
        try {
            if (income == null || income < 0) {
                throw new IllegalArgumentException("Income cannot be null or negative");
            }

            // 简单的税务计算逻辑
            double tax = income * 0.2; // 假设税率为20%
            return ResponseEntity.ok(tax);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 异常处理
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
