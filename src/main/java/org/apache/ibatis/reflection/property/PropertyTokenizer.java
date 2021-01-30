package org.apache.ibatis.reflection.property;

import java.util.Iterator;

/**
 * @author :LiuYang
 * @desc
 * 属性分解为标记，迭代子模式
 * 如person[0].birthdate.year，将依次取得person[0], birthdate, year
 * @date :2021/1/30/030 13:08
 **/
public class PropertyTokenizer implements Iterable<PropertyTokenizer>,Iterator<PropertyTokenizer>{
    //例子： person[0].birthdate.year
    private String name; //person
    private String indexedName; //person[0]
    private String index; //0
    private String children; ////birthdate.year

    public PropertyTokenizer(String fullname){
        //person[0].birthdate.year
        //找.
        int delim=fullname.indexOf('.');
        if(delim>-1){
            name=fullname.substring(0,delim);
            children=fullname.substring(delim+1);
        }else{
            //找不到.的话，取全部部分
            name=fullname;
            children=null;
        }
        indexedName=name;
        delim=name.indexOf('[');
        if(delim>-1){
            index=name.substring(delim+1,name.length()-1);
            name=name.substring(0,delim);
        }
    }

    public String getName() {
        return name;
    }

    public String getIndexedName() {
        return indexedName;
    }

    public String getIndex() {
        return index;
    }

    public String getChildren() {
        return children;
    }

    @Override
    public Iterator<PropertyTokenizer> iterator() {
        return this;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove is not supported, as it has no meaning in the context of properties.");
    }

    @Override
    public boolean hasNext() {
        return children!=null;
    }

    @Override
    public PropertyTokenizer next() {
        return new PropertyTokenizer(children);
    }
}
