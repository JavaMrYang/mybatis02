package org.apache.ibatis.executor;

import org.apache.ibatis.reflection.MetaObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :LiuYang
 * @desc
 * 结果延迟加载映射
 * @date :2021/1/30/030 12:59
 **/
public class ResultLoaderMap {
    //加载对的hashmap
    private final Map<String,LoadPair> loaderMap=new HashMap<>();

    //把要延迟加载的属性记到ResultLoaderMap里（一个哈希表）
    public void addLoader(String property, MetaObject metaResultObject,ResultLoader resultLoader){

    }


    //此处用一个静态内部
    public static class LoadPair implements Serializable{

    }
}
