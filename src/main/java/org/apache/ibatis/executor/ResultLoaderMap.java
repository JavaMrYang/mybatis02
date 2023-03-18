package org.apache.ibatis.executor;

import org.apache.ibatis.exceptions.ExecutorException;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.reflection.MetaObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
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
        //获取第一个属性英文转大写
        String upperFirst=getUppercaseFirstProperty(property);
        if(!upperFirst.equalsIgnoreCase(property)&&this.loaderMap.containsKey(upperFirst)){
            throw new ExecutorException("Nested lazy loaded result property '" + property + "' for query id '" + resultLoader.mappedStatement.getId() + " already exists in the result map. The leftmost property of all lazy loaded properties must be unique within a result map.");
        }
    }

    /**
     * 将string前面的.中文转成大写
     * @param property
     * @return
     */
    private static String getUppercaseFirstProperty(String property){
        String[] part=property.split("\\.");
        return part[0].toUpperCase(Locale.ENGLISH);
    }


    //此处用一个静态内部
    public static class LoadPair implements Serializable{
        private static final String FACTORY_METHOD = "getConfiguration";
        private transient MetaObject metaResultObject;
        private transient ResultLoader resultLoader;
        private transient Log log;
        private String property;

        private LoadPair(String property,MetaObject metaResultObject, ResultLoader resultLoader){
           // this.serializationCheck=new Object();
            this.property = property;
            this.metaResultObject = metaResultObject;
            this.resultLoader = resultLoader;
            if(metaResultObject!=null&&metaResultObject.getOriginalObject() instanceof Serializable){
                //Object mappedStatementParameter=resultLoader.;
            }
        }


    }
}
