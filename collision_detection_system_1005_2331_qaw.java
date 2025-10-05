// 代码生成时间: 2025-10-05 23:31:32
package com.example.collisiondetectionsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import java.awt.geom.Ellipse2D;

@SpringBootApplication
@RestController
public class CollisionDetectionSystemApplication {
# 优化算法效率

    public static void main(String[] args) {
        SpringApplication.run(CollisionDetectionSystemApplication.class, args);
    }

    @GetMapping("/detectCollision")
    public ResponseEntity<Object> detectCollision(
            @RequestParam(name = "x1", required = false) Double x1,
            @RequestParam(name = "y1", required = false) Double y1,
            @RequestParam(name = "x2", required = false) Double x2,
            @RequestParam(name = "y2", required = false) Double y2,
# NOTE: 重要实现细节
            @RequestParam(name = "radius1", required = false) Double radius1,
            @RequestParam(name = "radius2", required = false) Double radius2) {
        try {
            if (x1 == null || y1 == null || x2 == null || y2 == null || radius1 == null || radius2 == null) {
                throw new IllegalArgumentException("All parameters are required");
            }

            boolean isCollision = isCollision(x1, y1, radius1, x2, y2, radius2);
            return ResponseEntity.ok().body(isCollision);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    private boolean isCollision(double x1, double y1, double radius1, double x2, double y2, double radius2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double sumRadius = radius1 + radius2;
        return distance < sumRadius;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
