package org.apache.ibatis.reflection.invoker;

import java.lang.reflect.InvocationTargetException;

/**
 * @author :LiuYang
 * @desc
 * 调用者
 * @date :2021/1/31/031 17:12
 **/
public interface Invoker {
    //调用
    Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException;

    //取得类型
    Class<?> getType();
}
