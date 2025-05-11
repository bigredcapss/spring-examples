package com.peanut.example.extensionpoints.config;

import com.peanut.example.extensionpoints.extension.MyBeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author peanut
 * @description
 */
@Configuration
public class BeanDefinitionRegistryPostProcessorConfig {


    /**
     * 为避免Spring 在解析配置类时提前实例化 BeanDefinitionRegistryPostProcessor，
     * 通过将@Bean 方法声明为静态方法，可以避免此问题。使用静态方法的方式，因为它更明确地表明该方法不会依赖于配置类的实例
     * @return
     */
    @Bean
    public static MyBeanDefinitionRegistryPostProcessor myBeanDefinitionRegistryPostProcessor() {
        System.out.println("BeanDefinitionRegistryPostProcessorConfig init");
        return new MyBeanDefinitionRegistryPostProcessor();
    }
}
