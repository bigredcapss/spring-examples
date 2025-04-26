package com.peanut.example.extensionpoints.extension;

/**
 * ApplicationContextInitializer:
 * 作用:
 * 1、ApplicationContextInitializer 是 Spring 框架提供的一个接口，
 * 用于在 Spring 应用上下文（ApplicationContext）初始化之前执行自定义逻辑。
 * 它允许开发者在上下文刷新之前对 ApplicationContext 进行配置或修改。
 * 使用场景：
 * 1、环境配置：在应用启动前设置环境变量或配置属性。
 * 2、动态注册 Bean：在上下文初始化前动态注册 Bean。
 * 3、自定义属性源：添加自定义的属性源（如数据库、远程配置等）。
 * 4、上下文预处理：对 ApplicationContext 进行预处理，例如修改默认配置。
 * 注意事项:
 * 1、ApplicationContextInitializer 在 ApplicationContext 初始化之前执行，因此不能依赖任何 Bean
 */


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author peanut
 * @description 自定义ApplicationContextInitializer
 * 使用步骤：
 * 1、自定义ApplicationContextInitializer
 * 2、注册ApplicationContextInitializer
 *  2.1、通过 application.properties 注册
 *  2.2、通过 SpringApplication 注册
 * 3、启动服务,观察日志
 */
@Slf4j
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        // 添加自定义环境变量
        Map<String, Object> customProperties = new HashMap<>();
        customProperties.put("custom.property", "custom-value");

        environment.getPropertySources().addFirst(new MapPropertySource("customProperties", customProperties));
        log.info("自定义环境变量已设置");
    }
}
