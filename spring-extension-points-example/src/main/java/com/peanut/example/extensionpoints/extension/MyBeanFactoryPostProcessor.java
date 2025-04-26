package com.peanut.example.extensionpoints.extension;

/**
 * BeanFactoryPostProcessor:
 * 作用：
 * BeanFactoryPostProcessor 是 Spring 框架提供的一个扩展点，
 * 用于在 Spring 容器实例化 Bean 之前修改 Bean 的定义（BeanDefinition）。
 * 它允许开发者在 Bean 实例化之前对容器中的 Bean 定义进行动态修改或增强。
 * 1、在 Spring 容器加载 Bean 定义后、实例化 Bean 之前，对 Bean 定义进行修改。
 * 2、可以用于动态注册 Bean、修改 Bean 属性、添加自定义逻辑等。
 * 使用场景：
 * 1、动态注册 Bean：在运行时动态向容器中注册新的 Bean。
 * 2、修改 Bean 定义：修改已注册 Bean 的属性或行为。
 * 3、条件化配置：根据条件动态调整 Bean 的配置。
 * 4、自定义属性解析：解析自定义的配置属性并应用到 Bean 定义中。
 * 注意事项：
 * 1、BeanFactoryPostProcessor 在 Bean 实例化之前执行，因此不能直接操作 Bean 实例。
 * 2、BeanFactoryPostProcessor：在 Bean 实例化之前执行，用于修改 Bean 定义。
 * 3、BeanPostProcessor：在 Bean 实例化之后执行，用于修改 Bean 实例。
 * 4、动态注册 Bean 会增加容器启动时间，需谨慎使用
 */



import com.peanut.example.extensionpoints.pojo.MyObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Service;

/**
 * @author peanut
 * @description 自定义BeanFactoryPostProcessor接口
 */
@Slf4j
@Service
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * 使用场景：动态注册一个 Bean
     */

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        // 将 ConfigurableListableBeanFactory 转换为 DefaultListableBeanFactory
        DefaultListableBeanFactory defaultBeanFactory = (DefaultListableBeanFactory) beanFactory;

        // 动态注册一个 Bean
        BeanDefinition beanDefinition = BeanDefinitionBuilder
                .rootBeanDefinition(MyObject.class) // 指定 Bean 的类
                .setScope(BeanDefinition.SCOPE_SINGLETON) // 设置作用域
                .getBeanDefinition();

        // 注册 Bean 到容器中
        defaultBeanFactory.registerBeanDefinition("myDynamicBean", beanDefinition);
        log.info("动态 Bean 已注册: myDynamicBean");



    }
}
