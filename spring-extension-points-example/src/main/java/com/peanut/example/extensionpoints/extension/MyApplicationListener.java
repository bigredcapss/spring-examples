package com.peanut.example.extensionpoints.extension;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author peanut
 * @description 实现ApplicationListener接口, 监听Spring事件
 */
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 处理事件
    }

}
