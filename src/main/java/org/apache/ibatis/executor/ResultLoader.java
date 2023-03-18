package org.apache.ibatis.executor;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;

public class ResultLoader {
    protected Configuration configuration;
    protected final MappedStatement mappedStatement;
    protected final Object parameterObject;

    public ResultLoader(Configuration config, Executor executor, MappedStatement mappedStatement, Object parameterObject, Class<?> targetType, CacheKey cacheKey, BoundSql boundSql) {
        this.configuration = config;
        this.mappedStatement = mappedStatement;
        this.parameterObject = parameterObject;
    }

    public ResultLoader(MappedStatement mappedStatement, Object parameterObject) {
        this.mappedStatement = mappedStatement;
        this.parameterObject = parameterObject;
    }
}
