package com.peanut.example.extensionpoints.extension;

import com.peanut.example.extensionpoints.pojo.MyObject;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author peanut
 * @description FactoryBean,用于创建复杂的Bean对象
 */
public class MyFactoryBean implements FactoryBean<MyObject> {
    @Override
    public MyObject getObject() throws Exception {
        // 返回自定义对象
        return new MyObject();
    }

    @Override
    public Class<?> getObjectType() {
        return MyObject.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
