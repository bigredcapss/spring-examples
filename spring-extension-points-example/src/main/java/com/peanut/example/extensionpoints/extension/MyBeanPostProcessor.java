package com.peanut.example.extensionpoints.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author peanut
 * @description 自定义BeanPostProcessor,在Bean初始化前后进行自定义处理
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        // 初始化前的逻辑
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 初始化后的逻辑
        return bean;
    }

}
