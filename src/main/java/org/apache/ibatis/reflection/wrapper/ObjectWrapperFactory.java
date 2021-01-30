package org.apache.ibatis.reflection.wrapper;

import org.apache.ibatis.reflection.MetaObject;

/**
 * @author :LiuYang
 * @desc
 * 对象包装器工厂
 * @date :2021/1/30/030 14:01
 **/
public interface ObjectWrapperFactory {

    //有没有包装器
    boolean hasWrapperFor(Object object);

    //得到包装器
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);
}
