package com.peanut.example.extensionpoints;

import com.peanut.example.extensionpoints.config.BeanDefinitionRegistryPostProcessorConfig;
import com.peanut.example.extensionpoints.config.FactoryBeanConfig;
import com.peanut.example.extensionpoints.pojo.MyBusiness;
import com.peanut.example.extensionpoints.pojo.MyObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author peanut
 * @description 启动类
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        ApplicationContext context1 = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
        MyObject myObject = context1.getBean("myFactoryBean", MyObject.class);
        System.out.println("Retrieved MyObject: " + myObject);

        ApplicationContext context2 = new AnnotationConfigApplicationContext(BeanDefinitionRegistryPostProcessorConfig.class);
        MyBusiness myBusiness = context2.getBean("myBusiness", MyBusiness.class);
        System.out.println("Retrieved MyBusiness: " + myBusiness);

    }
}
