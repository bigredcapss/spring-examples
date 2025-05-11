package com.peanut.example.extensionpoints.extension;

/**
 * BeanDefinitionRegistryPostProcessor
 * 作用：
 * BeanDefinitionRegistryPostProcessor 是 Spring 框架中的一个扩展接口，用于在 Spring 容器初始化过程中动态注册
 * 或修改 Bean 的定义（BeanDefinition）。它是 BeanFactoryPostProcessor 的子接口，提供了更早的扩展点，
 * 允许在 Bean 实例化之前对 Bean 的定义进行操作。
 *
 * 使用场景：
 * 1、动态注册 Bean：当需要在运行时根据条件动态注册 Bean 时。
 * 2、修改 Bean 定义：当需要修改 Spring 容器中已注册的 Bean 的定义时。
 * 3、插件化扩展：在框架或插件开发中，用于扩展 Spring 容器的功能。
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author peanut
 * @description
 */
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(MyBeanDefinitionRegistryPostProcessor.class);
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        logger.info("Starting postProcessBeanDefinitionRegistry...");
        // 动态注册一个 Bean 定义
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName("com.peanut.example.extensionpoints.pojo.MyBusiness");
        beanDefinition.setScope("singleton"); // 设置作用域为单例

        // 注册 Bean 定义
        registry.registerBeanDefinition("myBusiness", beanDefinition);
        logger.info("Registered new Bean: myBusiness");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("Starting postProcessBeanFactory...");
        // 可以在这里对 BeanFactory 进行进一步处理
    }
}
