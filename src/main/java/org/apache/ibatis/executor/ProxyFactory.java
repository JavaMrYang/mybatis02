package org.apache.ibatis.executor;

import java.util.Properties;

/**
 * @author :LiuYang
 * @desc
 * 延迟加载代理工厂
 * @date :2021/1/30/030 12:57
 **/
public interface ProxyFactory {
    void setProperties(Properties properties);

    Object createProxy(Object target);
}
