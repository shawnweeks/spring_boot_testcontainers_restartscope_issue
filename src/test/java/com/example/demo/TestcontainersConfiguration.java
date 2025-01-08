package com.example.demo;

import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
class TestContainersConfiguration {

    @Bean
    @RestartScope
    public PostgreSQLContainer<?> postgreSQLContainer() {
        PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16");
        postgreSQLContainer.start();
        return postgreSQLContainer;
    }

    @Bean
    DynamicPropertyRegistrar dynamicPropertyRegistrar(PostgreSQLContainer<?> postgreSQLContainer){
        return (registry) -> {
            registry.add("JDBC_URL", postgreSQLContainer::getJdbcUrl);
            registry.add("JDBC_USERNAME", postgreSQLContainer::getUsername);
            registry.add("JDBC_PASSWORD", postgreSQLContainer::getPassword);
        };
    }

}
