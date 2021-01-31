package com.study.mybatis.reflection;

import com.study.mybatis.reflection.fz.Student;
import org.apache.ibatis.reflection.invoker.GetFieldInvoker;
import org.apache.ibatis.reflection.invoker.Invoker;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/1/31/031 17:36
 **/
public class TestGetFiledInvoker {

    @Test
    public void testField(){
        Student.Builder builder=new Student.Builder("001");
        builder.buildName("张三");
        Student student=builder.build();
        Field[] fields=student.getClass().getDeclaredFields(); //获取类中已经声明的字段
        for(Field field:fields){
            Invoker invoker=new GetFieldInvoker(field);
            Class classType=invoker.getType();
            try {
                //System.out.println(field.isAccessible());
                if(!field.isAccessible()){
                    field.setAccessible(true);
                }
                Object obj=invoker.invoke(student,null);
                System.out.println(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println("filed:"+field.getName());
        }

    }
}
