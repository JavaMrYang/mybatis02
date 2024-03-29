package org.apache.ibatis.mapping;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.Configuration;

import java.util.List;

/**
 * 映射语句
 */
public class MappedStatement {
    private String resource;
    private Configuration configuration;
    private String id;
    private Integer fetchSize;
    private Integer timeout;
    private StatementType statementType;
    private ResultSetType resultSetType;
    //SQL源码
    private SqlSource sqlSource;
   /* private Cache cache;
    private ParameterMap parameterMap;
    private List<ResultMap> resultMaps;*/
    private boolean flushCacheRequired;
    private boolean useCache;
    private boolean resultOrdered;
    private SqlCommandType sqlCommandType;
    //private KeyGenerator keyGenerator;
    private String[] keyProperties;
    private String[] keyColumns;
    private boolean hasNestedResultMaps;
    private String databaseId;
    private Log statementLog;
    //private LanguageDriver lang;
    private String[] resultSets;

    public String getId() {
        return this.id;
    }
}
