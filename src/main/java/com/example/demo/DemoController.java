package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final JdbcClient firstJdbcClient;
    private final JdbcClient seconddJbcClient;

    public DemoController(@Qualifier("firstDataSource") DataSource ds1, @Qualifier("secondDataSource") DataSource ds2){
        firstJdbcClient = JdbcClient.create(ds1);
        seconddJbcClient = JdbcClient.create(ds2);
    }

    @GetMapping("/first")
    public String first() {        
        return String.format("Hello World %s", firstJdbcClient.sql("select current_timestamp").query().singleValue());
    }


    @GetMapping("/second")
    public String second() {        
        return String.format("Hello World %s", seconddJbcClient.sql("select current_timestamp").query().singleValue());
    }
}
