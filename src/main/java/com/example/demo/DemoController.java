package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${MY_REDIS_HOST}")
    private String redistHost;
    @Value("${MY_REDIS_PORT}")
    private String redisPort;
    @Value("${MY_REDIS_PASSWORD}")
    private String redistPassword;

    @GetMapping("/")
    public String index() {
        return String.format("Redis Host: %s, Redist Port: %s, Redis Password: %s", redistHost, redisPort, redistPassword);
    }
}
