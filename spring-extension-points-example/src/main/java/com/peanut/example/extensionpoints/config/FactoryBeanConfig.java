package com.peanut.example.extensionpoints.config;

import com.peanut.example.extensionpoints.extension.MyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author peanut
 * @description 配置类
 */
@Configuration
public class FactoryBeanConfig {


    @Bean
    public static MyFactoryBean myFactoryBean() {
        System.out.println("FactoryBeanConfig init");
        return new MyFactoryBean();

    }
}
