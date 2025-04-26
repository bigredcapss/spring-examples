package com.peanut.example.extensionpoints.bestpractice;

import com.peanut.example.extensionpoints.service.HelloService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @PostConstruct:
 * 作用：
 * 它用于标记一个方法，在 Bean 初始化完成后(完成依赖注入后)立即执行。通常用于执行一些初始化逻辑。
 * 使用场景：
 * 1、数据初始化：在 Bean 初始化完成后加载数据或配置。
 * 2、资源准备：初始化数据库连接、缓存等资源。
 * 3、状态检查：验证 Bean 的状态或依赖是否正常。
 * 4、日志记录：记录 Bean 初始化完成的信息。
 */


/**
 * @author peanut
 * @description @PostConstruct 注解的使用
 */

@Service
@Slf4j
public class UsePostConstruct {

    /**
     * 场景1：数据初始化
     */
    private Map<String, String> cache;

    @PostConstruct
    public void initCache() {
        cache = new HashMap<>();
        // 模拟加载缓存数据
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        log.info("缓存初始化完成");
    }

    public String getValue(String key) {
        return cache.get(key);
    }

    /**
     * 场景2：状态检查-验证依赖注入
     */
    private final HelloService helloService;

    @Autowired
    public UsePostConstruct(HelloService helloService) {
        this.helloService = helloService;
    }

    @PostConstruct
    public void checkDependencies() {
        if (helloService == null) {
            throw new IllegalStateException("依赖注入失败，请检查 HelloService 是否被正确注入");
        }
        log.info("依赖注入成功，HelloService 已被正确注入");
    }




}
