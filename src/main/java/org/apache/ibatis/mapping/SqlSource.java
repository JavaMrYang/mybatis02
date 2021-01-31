package org.apache.ibatis.mapping;

/**
 * @author :LiuYang
 * @desc
 * SQL源码
 * @date :2021/1/31/031 16:53
 **/
public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);
}
