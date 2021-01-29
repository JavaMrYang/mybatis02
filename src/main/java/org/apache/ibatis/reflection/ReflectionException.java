package org.apache.ibatis.reflection;

import org.apache.ibatis.exceptions.PersistenceException;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/1/30/030 0:08
 **/
public class ReflectionException extends PersistenceException {

    public ReflectionException() {
        super();
    }

    public ReflectionException(String message) {
        super(message);
    }

    public ReflectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReflectionException(Throwable cause) {
        super(cause);
    }
}
