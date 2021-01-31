package org.apache.ibatis.session;

import org.apache.ibatis.binging.MapperRegistry;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.type.JdbcType;
import sun.rmi.runtime.Log;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * mybatis配置项
 */
public class Configuration {
    //环境
    protected Environment environment;

    //---------以下都是<settings>节点-------
    protected boolean safeRowBoundsEnabled = false;
    protected boolean safeResultHandlerEnabled = true;
    protected boolean mapUnderscoreToCamelCase = false;
    protected boolean aggressiveLazyLoading = true;
    protected boolean multipleResultSetsEnabled = true;
    protected boolean useGeneratedKeys = false;
    protected boolean useColumnLabel = true;

    //默认启用缓存
    protected boolean cacheEnabled = true;
    protected boolean callSettersOnNulls = false;

    protected String logPrefix;
    protected Class <? extends Log> logImpl;
    //开启什么样的缓存类型
    protected LocalCacheScope localCacheScope = LocalCacheScope.SESSION;
    protected JdbcType jdbcTypeForNull = JdbcType.OTHER;
    protected Set<String> lazyLoadTriggerMethods = new HashSet<String>(Arrays.asList(new String[] { "equals", "clone", "hashCode", "toString" }));
    protected Integer defaultStatementTimeout;

    //简单执行器的类型
    protected ExecutorType executorType=ExecutorType.SIMPLE;
    protected AutoMappingBehavior autoMappingBehavior=AutoMappingBehavior.PARTIAL;
    //---------以上都是<settings>节点-------

    protected Properties variables=new Properties();
    //对象工厂和对象包装器工厂
    protected ObjectFactory objectFactory=new DefaultObjectFactory();
    protected ObjectWrapperFactory objectWrapperFactory=new DefaultObjectWrapperFactory();
    //映射注册机
    protected MapperRegistry mapperRegistry=new MapperRegistry(this);

}
