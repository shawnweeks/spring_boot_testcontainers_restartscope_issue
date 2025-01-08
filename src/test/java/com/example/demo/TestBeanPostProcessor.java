package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class TestBeanPostProcessor  implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("demoDataSource");        
        // This used to work and I've also tried with dynamicPropertyRegistrar
        beanDefinition.setDependsOn("dynamicPropertyRegistry");
    }

}
