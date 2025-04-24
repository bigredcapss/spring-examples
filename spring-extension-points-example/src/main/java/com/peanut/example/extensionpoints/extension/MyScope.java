package com.peanut.example.extensionpoints.extension;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * @author peanut
 * @description 实现Scope接口,定义自定义作用域
 */
public class MyScope implements Scope {
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        // 自定义作用域逻辑
        return null;
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
