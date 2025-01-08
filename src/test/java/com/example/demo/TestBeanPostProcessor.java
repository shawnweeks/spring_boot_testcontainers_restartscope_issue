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
        BeanDefinition firstBeanDefinition = beanFactory.getBeanDefinition("firstDataSource");        
        BeanDefinition secondBeanDefinition = beanFactory.getBeanDefinition("secondDataSource");        
        // This used to work and I've also tried with dynamicPropertyRegistrar
        firstBeanDefinition.setDependsOn("dynamicPropertyRegistry");
        secondBeanDefinition.setDependsOn("dynamicPropertyRegistry");
    }

}
