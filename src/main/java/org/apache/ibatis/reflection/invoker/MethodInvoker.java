package org.apache.ibatis.reflection.invoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/1/31/031 17:22
 **/
public class MethodInvoker implements Invoker{
    private Class<?> type;
    private Method method;

    public MethodInvoker(Method method) {
        this.method = method;

        //如果只有一个参数，返回参数类型，否则返回return的类型
        if (method.getParameterTypes().length == 1) {
            type = method.getParameterTypes()[0];
        } else {
            type = method.getReturnType();
        }
    }

    //就是调用Method.invoke
    @Override
    public Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException {
        return method.invoke(target, args);
    }

    @Override
    public Class<?> getType() {
        return type;
    }
}
