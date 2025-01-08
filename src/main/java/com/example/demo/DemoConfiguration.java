package com.example.demo;

import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DemoConfiguration {
    
    @Bean
    public FilterRegistrationBean<DemoFilter> demoFilterRegistration(DemoFilter filter) {
        FilterRegistrationBean<DemoFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Bean
    public DelegatingFilterProxyRegistrationBean demoFilterProxyRegistration() {
        return new DelegatingFilterProxyRegistrationBean("demoFilter");
    }
}
