// src/main/java/com/example/MyApp.java
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyApp {
    
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
    
    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot in Kubernetes!";
    }
    
    @GetMapping("/health")
    public String health() {
        return "{\"status\":\"UP\"}";
    }
}
