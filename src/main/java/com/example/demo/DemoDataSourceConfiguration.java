package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DemoDataSourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.demo")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public PlatformTransactionManager firstTransactionManager(@Qualifier("firstDataSource") DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    @Bean
    @ConfigurationProperties("app.datasource.demo")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public PlatformTransactionManager secondTransaction2Manager(@Qualifier("secondDataSource") DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
}
