package com.peanut.example.extensionpoints.extension;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author peanut
 * @description 实现MethodInterceptor接口,拦截方法调用，实现切面编程
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 方法调用前逻辑
        // ...

        // 执行目标方法
        Object result = invocation.proceed();
        // ...

        // 方法调用后逻辑
        return result;
    }
}
