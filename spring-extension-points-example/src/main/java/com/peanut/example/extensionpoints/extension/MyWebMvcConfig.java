package com.peanut.example.extensionpoints.extension;


import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author peanut
 * @description 实现WebMvcConfigurer接口,自定义Spring MVC配置
 */
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器
    }

}
