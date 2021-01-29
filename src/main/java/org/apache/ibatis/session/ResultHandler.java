package org.apache.ibatis.session;

public interface ResultHandler {

    //处理结果，给个结果上下文
    void handlerResult();
}
