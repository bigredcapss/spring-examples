package com.peanut.example.extensionpoints.extension;

/**
 * InitializingBean:
 * 作用:
 * 1、InitializingBean 是 Spring 提供的一个接口，用于在 Bean 初始化完成后执行自定义逻辑。
 * 它定义了一个 afterPropertiesSet 方法，Spring 会在 Bean 的属性设置完成后自动调用该方法；
 * 在 Bean 的属性注入完成后，执行初始化逻辑。
 * 2、类似于 @PostConstruct 注解，但 InitializingBean 是一个接口。
 * 使用场景：
 * 1、数据初始化：在 Bean 初始化后加载数据或配置。
 * 2、资源准备：初始化数据库连接、缓存等资源。
 * 3、状态检查：验证 Bean 的状态或依赖是否正常。
 * 4、复杂初始化：执行需要依赖注入完成后才能进行的逻辑
 */


import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author peanut
 * @description InitializingBean
 * 使用步骤：
 * 1、自定义InitializingBean
 * 2、启动服务,观察日志
 */
public class MyInitializingBean implements InitializingBean {


    /**
     * 场景：初始化缓存数据
     */
    private Map<String, String> cache;

    @Override
    public void afterPropertiesSet() throws Exception {
        cache = new HashMap<>();
        // 模拟加载缓存数据
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        System.out.println("缓存数据初始化完成");
    }

    public String getValue(String key) {
        return cache.get(key);
    }
}
