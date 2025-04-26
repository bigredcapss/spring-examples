package com.peanut.example.extensionpoints.extension;


/**
 * BeanPostProcessor:
 * 作用：
 * BeanPostProcessor 是 Spring 框架提供的一个扩展点，
 * 用于在 Bean 初始化前后执行自定义逻辑。
 * 它允许开发者在 Bean 的生命周期中插入自定义的处理逻辑。
 * 可以用于修改 Bean 实例、添加代理、记录日志等
 * 使用场景：
 * 1、AOP 代理：在 Bean 初始化后为其创建代理对象。
 * 2、日志记录：在 Bean 初始化前后记录日志。
 * 3、属性校验：在 Bean 初始化后校验其属性。
 * 4、动态修改 Bean：在 Bean 初始化后修改其状态或行为。
 * 注意事项：
 * 1、执行顺序：BeanPostProcessor 会应用于所有 Bean，执行顺序由 Ordered 接口或 @Order 注解控制。
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.view.BeanNameViewResolver;

/**
 * @author peanut
 * @description 自定义BeanPostProcessor
 */
@Component
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Bean 初始化前:" + beanName);
        // 初始化前的逻辑
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean) {
            MyBean myBean = (MyBean) bean;
            myBean.setStatus("初始化后");
        }
        if (bean instanceof BeanNameViewResolver){
            BeanNameViewResolver beanNameViewResolver = (BeanNameViewResolver) bean;
            log.info("BeanNameViewResolver属性值:"+beanNameViewResolver.getOrder());

        }
        // 初始化后日志打印
        log.info("Bean 初始化后:" + beanName);
        return bean;
    }



}

class MyBean {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
