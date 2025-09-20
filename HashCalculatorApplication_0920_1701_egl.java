// 代码生成时间: 2025-09-20 17:01:38
package com.example.hashcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.security.MessageDigest;
import javax.annotation.PostConstruct;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class HashCalculatorApplication {

    private static final Map<String, String> ALGORITHMS = new HashMap<>();

    @PostConstruct
    public void init() {
        ALGORITHMS.put("MD5", "MD5");
        ALGORITHMS.put("SHA-1", "SHA-1");
        ALGORITHMS.put("SHA-256", "SHA-256");
        ALGORITHMS.put("SHA-384", "SHA-384");
        ALGORITHMS.put("SHA-512", "SHA-512");
    }

    @GetMapping("/hash")
    public ResponseEntity<String> calculateHash(@RequestParam String algorithm, @RequestParam String input) {
# NOTE: 重要实现细节
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
# FIXME: 处理边界情况
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return ResponseEntity.ok("Hash value: " + hexString.toString());
# 添加错误处理
        } catch (NoSuchAlgorithmException e) {
            return ResponseEntity.badRequest().body("Invalid algorithm: " + algorithm);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(HashCalculatorApplication.class, args);
    }
}
