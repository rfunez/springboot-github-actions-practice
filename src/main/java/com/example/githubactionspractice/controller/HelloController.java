package com.example.githubactionspractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public Greeting hello() {
        return new Greeting("Hello from Spring Boot!");
    }

    public record Greeting(String message) {
    }
}
