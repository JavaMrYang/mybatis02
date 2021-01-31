package org.apache.ibatis.reflection;

/**
 * @author :LiuYang
 * @desc
 * 原类
 * @date :2021/1/31/031 17:10
 **/
public class MetaClass {
    //有一个反射器
    //可以看到方法基本都是再次委派给这个Reflector
    private Reflector reflector;

    private MetaClass(Class<?> type) {
        this.reflector = Reflector.forClass(type);
    }

    public static MetaClass forClass(Class<?> type) {
        return new MetaClass(type);
    }
}
