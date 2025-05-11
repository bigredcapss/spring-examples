package com.peanut.example.extensionpoints.extension;

/**
 * FactoryBean,
 * 作用：
 * FactoryBean 是 Spring 框架中的一个接口，
 * 用于创建复杂的 Bean 对象。它允许开发者自定义 Bean 的创建逻辑，
 * 而不是直接通过 Spring 的默认机制来实例化 Bean。
 *
 * 使用场景：
 * 1、自定义对象创建：当需要创建的对象逻辑复杂时，可以通过 FactoryBean 封装创建过程。
 * 2、动态代理：用于创建 AOP 代理对象或其他动态代理对象。
 * 3、第三方库集成：当需要集成第三方库，且该库的实例化过程需要特殊处理时
 *
 * 注意事项：
 * FactoryBean 是 Spring 中用于自定义 Bean 创建逻辑的强大工具，
 * 适用于复杂对象创建、动态代理等场景。通过实现 FactoryBean 接口，开发者可以灵活控制 Bean 的实例化过程，并在创建过程中添加日志等额外逻辑。
 */







import com.peanut.example.extensionpoints.pojo.MyObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author peanut
 * @description FactoryBean,用于创建复杂的Bean对象
 */
public class MyFactoryBean implements FactoryBean<MyObject> {

    private static final Logger logger = LoggerFactory.getLogger(MyFactoryBean.class);
    @Override
    public MyObject getObject() throws Exception {
        // 自定义对象的创建逻辑
        logger.info("Creating MyObject instance...");
        MyObject myObject = new MyObject();
        myObject.setName("Custom Object");
        logger.info("MyObject created: {}", myObject);
        return myObject;
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
