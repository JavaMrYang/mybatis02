package org.apache.ibatis.reflection;

import java.lang.reflect.Constructor;
import java.util.*;

/**
 * @author :LiuYang
 * @desc
 * 默认对象工厂，所有对象都要由工厂来产生
 * @date :2021/1/29/029 23:43
 **/
public class DefaultObjectFactory implements ObjectFactory{

    //默认没有属性可以设置
    @Override
    public void setProperties(Properties properties) {

    }

    @Override
    public <T> T create(Class<T> type) {
        return null;
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        //根据接口创建具体的类
        //1.解析接口
        Class<?> classToCreate=resolveInterface(type);

        //实例化类
        return (T) instantiateClass(classToCreate,constructorArgTypes,constructorArgs);
    }

    //2.实例化类
    private <T> T instantiateClass(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        try {
            Constructor<T> constructor;
            //如果没有传入constructor，调用空构造函数，核心是调用Constructor.newInstance
            if(constructorArgTypes==null||constructorArgs==null){
                constructor= type.getDeclaredConstructor();
                if(!constructor.isAccessible()){ //暴力破解
                    constructor.setAccessible(true);
                }
                return constructor.newInstance(constructorArgs.toArray(new Object[constructorArgs.size()]));
            }
            //如果传入constructor，调用传入的构造函数，核心是调用Constructor.newInstance
            constructor=type.getDeclaredConstructor(constructorArgs.toArray(new Class[constructorArgTypes.size()]));
            return constructor.newInstance(constructorArgs.toArray(new Object[constructorArgs.size()]));
        } catch (Exception e) {
            //如果出错，包装一下，重新抛出自己的异常
            StringBuilder argTypes=new StringBuilder();
            if(constructorArgTypes!=null){
                for(Class<?> argType:constructorArgTypes){
                    argTypes.append(argType.getSimpleName());
                    argTypes.append(",");
                }
            }
            StringBuilder argValues=new StringBuilder();
            if(constructorArgs!=null){
                for(Object argValue:constructorArgs){
                    argValues.append(String.valueOf(argValue));
                    argValues.append(",");
                }
            }
            throw new ReflectionException("Error instantiating " + type + " with invalid types (" + argTypes + ") or values (" + argValues + "). Cause: " + e, e);
        }
    }

    //1.解析接口,将interface转为实际class
    protected <T> Class<?> resolveInterface(Class<T> type) {
        Class<?> classToCreate=null;
        if(type==List.class||type== Collection.class||type==Iterable.class){
            //List|Collection|Iterable-->ArrayList
            classToCreate= ArrayList.class;
        }else if(type== Map.class){
            //Map->HashMap
            classToCreate=HashMap.class;
        }else if(type==SortedSet.class){
            //SortedSet->TreeSet
            classToCreate=TreeSet.class;
        }else if(type==Set.class){
            //Set->HashSet
            classToCreate=HashSet.class;
        }else{
            //除此以外，就用原来的类型
            classToCreate=type;
        }
        return classToCreate;
    }

    @Override
    public <T> T isCollection(Class<T> type) {
        return null;
    }
}
