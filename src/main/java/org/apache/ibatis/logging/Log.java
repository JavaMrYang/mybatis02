package org.apache.ibatis.logging;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/1/29/029 23:16
 **/
public interface Log {

    //和一般的log4j很像，提供日志接口的一些方法,error, debug, warn。
    //用自己的日志类恐怕是为了通用，不绑死在某个特定的日志框架中
    //但不是也有类似的slf4j吗？为何还要自己写？可能是不想引入额外的jar包
    boolean isDebugEnabled();
}
