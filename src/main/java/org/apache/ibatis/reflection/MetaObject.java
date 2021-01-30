package org.apache.ibatis.reflection;


import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.MapWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

import java.util.Map;

/**
 * @author :LiuYang
 * @desc
 * 元对象, 各种get，set方法有点ognl表达式的味道
 * 可以参考MetaObjectTest来跟踪调试，基本上用到了reflection包下所有的类
 * @date :2021/1/30/030 13:04
 **/
public class MetaObject {

    //有一个原来的对象，对象包装器，对象工厂，对象包装器工厂
    private Object originalObject;

    private ObjectWrapper objectWrapper;

    private ObjectFactory objectFactory;

    private ObjectWrapperFactory objectWrapperFactory;

    public MetaObject(Object object, ObjectFactory objectFactory, ObjectWrapperFactory objectWrapperFactory) {
        this.originalObject = object;
        this.objectFactory = objectFactory;
        this.objectWrapperFactory = objectWrapperFactory;

        if(object instanceof ObjectWrapper){
            //如果对象本身已经是ObjectWrapper型，则直接赋给objectWrapper
            this.objectWrapper = (ObjectWrapper) object;
        }else if(objectWrapperFactory.hasWrapperFor(object)){
            //如果有包装器,调用ObjectWrapperFactory.getWrapperFor
            this.objectWrapper = objectWrapperFactory.getWrapperFor(this, object);
        }else if(object instanceof Map){
            //如果是Map型，返回MapWrapper
            this.objectWrapper = new MapWrapper(this, (Map) object);
        }
    }

    public static MetaObject forObject(Object object, ObjectFactory objectFactory, ObjectWrapperFactory objectWrapperFactory) {
        if (object == null) {
            //处理一下null,将null包装起来
            return SystemMetaObject.NULL_META_OBJECT;
        } else {
            return new MetaObject(object, objectFactory, objectWrapperFactory);
        }
    }

    //取得值
    //如person[0].birthdate.year
    //具体测试用例可以看MetaObjectTest
    public Object getValue(String name) {
        PropertyTokenizer prop = new PropertyTokenizer(name);
        if (prop.hasNext()) {
            MetaObject metaValue = metaObjectForProperty(prop.getIndexedName());
            if (metaValue == SystemMetaObject.NULL_META_OBJECT) {
                //如果上层就是null了，那就结束，返回null
                return null;
            } else {
                //否则继续看下一层，递归调用getValue
                return metaValue.getValue(prop.getChildren());
            }
        } else {
            return objectWrapper.get(prop);
        }
    }

    //为某个属性生成元对象
    public MetaObject metaObjectForProperty(String name) {
        //实际是递归调用
        Object value = getValue(name);
        return MetaObject.forObject(value, objectFactory, objectWrapperFactory);
    }
}
