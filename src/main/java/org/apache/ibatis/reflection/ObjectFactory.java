package org.apache.ibatis.reflection;

import java.util.List;
import java.util.Properties;

/**
 * @author :LiuYang
 * @desc 对象工厂，所有对象都要由工厂来产生
 * @date :2021/1/29/029 23:35
 **/
public interface ObjectFactory {
    /**
     * 设置对象属性
     * @param properties
     */
    void setProperties(Properties properties);

    /**
     * 通过class字节码生成对象
     * @param type
     * @param <T>
     * @return
     */
    <T>T create(Class<T> type);

    /**
     * 生产对象，使用指定的构造函数和构造函数参数
     * @param type
     * @param constructorArgTypes
     * @param constructorArgs
     * @param <T>
     * @return
     */
    <T>T create(Class<T> type, List<Class<?>> constructorArgTypes,List<Object> constructorArgs);

    /**
     * 返回这个对象是否是集合
     * @param type
     * @param <T>
     * @return
     */
    <T>T isCollection(Class<T> type);
}
