package org.apache.ibatis.reflection.wrapper;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

import java.util.List;

/**
 * @author :LiuYang
 * @desc
 * 对象包装器
 * @date :2021/1/30/030 13:06
 **/
public interface ObjectWrapper {

    Object get(PropertyTokenizer prop);

    void set(PropertyTokenizer prop,Object value);

    //查找属性
    String findProperty(String name,boolean useCamelCaseMapping);

    //取得getter的名字列表
    String[] getGetterNames();

    //取得setter的名字列表
    String[] getSetterNames();

    //取得setter的类型
    Class<?> getSetterType(String name);

    //取得getter的类型
    Class<?> getGetterType(String name);

    //是否有指定的setter
    boolean hasSetter(String name);

    //是否有指定的getter
    boolean hasGetter(String name);

    //实例化属性
    MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory);

    //是否是集合
    boolean isCollection();

    //添加属性
    public void add(Object element);

    //添加属性
    public <E> void addAll(List<E> element);
}
