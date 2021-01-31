package org.apache.ibatis.mapping;

import org.apache.ibatis.reflection.MetaObject;

import java.util.List;
import java.util.Map;

/**
 * @author :LiuYang
 * @desc
 * 绑定的SQL,是从SqlSource而来，将动态内容都处理完成得到的SQL语句字符串，其中包括?,还有绑定的参数
 * @date :2021/1/31/031 16:54
 **/
public class BoundSql {
    private String sql;
    private List<ParameterMapping> parameterMappings;
    private Object parameterObject;
    private Map<String, Object> additionalParameters;
    private MetaObject metaParameters;
}
