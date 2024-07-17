package com.example.demo;

import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.GenericContainer;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

    @Bean
    @RestartScope
    public GenericContainer<?> redisContainer(DynamicPropertyRegistry registry) {
        GenericContainer<?> redisContainer = new GenericContainer<>("redis:7");
        redisContainer.withExposedPorts(6379);
        redisContainer.withCommand("redis-server", "--requirepass redis_user", "--save 60 1", "--loglevel debug");
        registry.add("MY_REDIS_HOST", () -> "localhost");
        registry.add("MY_REDIS_PORT", () -> redisContainer.getMappedPort(6379));
        registry.add("MY_REDIS_PASSWORD", () -> "redis_user");
        return redisContainer;
    }

}
