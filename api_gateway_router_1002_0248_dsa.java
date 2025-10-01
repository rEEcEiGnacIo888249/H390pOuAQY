// 代码生成时间: 2025-10-02 02:48:22
package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@SpringBootApplication
@RestController
public class ApiGatewayRouter {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayRouter.class, args);
    }

    // Define the routes
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/route1")
                        .uri("http://example.com/route1"))
                .route(p -> p
                        .path("/api/route2")
                        .uri("http://example.com/route2"))
                // Add more routes as needed
                .build();
    }

    // REST API endpoint
    @GetMapping("/api/**")
    public String apiGateway() {
        return "This is an API Gateway Router";
    }

    // Exception handling
    @ExceptionHandler
    public String handleException(ResponseStatusException ex) {
        return "Error: " + ex.getMessage();
    }
}
