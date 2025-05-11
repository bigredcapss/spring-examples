package com.peanut.example.extensionpoints.extension;

import com.peanut.example.extensionpoints.pojo.MyObject;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContextAware
 * 作用：
 * ApplicationContextAware 是 Spring 框架中的一个接口，用于让 Bean 获取到 Spring 的 ApplicationContext 对象。
 * 通过实现这个接口，Bean 可以在运行时访问 Spring 容器的上下文，从而获取其他 Bean 或进行其他操作
 *
 * 使用场景：
 * 1、获取 ApplicationContext：允许 Bean 在运行时访问 Spring 容器的上下文。
 * 2、动态获取其他 Bean：可以通过 ApplicationContext 动态获取其他 Bean 或资源。
 * 3、扩展功能：可以在 Bean 中实现一些需要依赖 ApplicationContext 的功能。
 *
 * 注意事项：
 * 1、避免滥用：通常情况下，推荐使用依赖注入（DI）来获取其他 Bean，而不是通过 ApplicationContextAware 手动获取。
 * 2、生命周期：ApplicationContext 是在 Bean 初始化时注入的，因此不能在构造函数中使用 ApplicationContext。
 */





/**
 * @author peanut
 * @description MyComponent实现ApplicationContextAware,让Bean获取到ApplicationContext实例
 */
@Component
public class MyApplicationContext implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void getContext() {
        // 使用 ApplicationContext 获取其他 Bean
        MyObject myObject = context.getBean(MyObject.class);
        System.out.println("my object is"+myObject.toString());
    }

}
