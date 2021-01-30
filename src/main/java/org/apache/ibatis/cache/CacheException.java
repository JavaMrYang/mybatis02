package org.apache.ibatis.cache;

/**
 * @author :LiuYang
 * @desc
 * 缓存异常
 * @date :2021/1/30/030 13:33
 **/
public class CacheException extends RuntimeException{

    public CacheException() {
    }

    public CacheException(String message) {
        super(message);
    }

    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }

    public CacheException(Throwable cause) {
        super(cause);
    }
}
