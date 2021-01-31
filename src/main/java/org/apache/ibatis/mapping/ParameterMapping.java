package org.apache.ibatis.mapping;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/1/31/031 16:55
 **/
public class ParameterMapping {

    private Configuration configuration;

    //例子：#{property,javaType=int,jdbcType=NUMERIC}

    //property
    private String property;
    //mode
    private ParameterMode mode;
    //javaType=int
    private Class<?> javaType = Object.class;
    //jdbcType=NUMERIC
    private JdbcType jdbcType;
    //numericScale
    private Integer numericScale;
    private TypeHandler<?> typeHandler;
    private String resultMapId;
    //jdbcType=NUMERIC
    private String jdbcTypeName;
    private String expression;

    private ParameterMapping() {
    }
}
