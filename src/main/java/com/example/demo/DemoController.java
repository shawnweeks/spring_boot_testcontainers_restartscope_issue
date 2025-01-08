package com.example.demo;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final JdbcClient jdbcClient;

    public DemoController(DataSource ds){
        jdbcClient = JdbcClient.create(ds);
    }

    @GetMapping("/")
    public String index() {        
        return String.format("Hello World %s", jdbcClient.sql("select current_timestamp").query().singleValue());
    }
}
