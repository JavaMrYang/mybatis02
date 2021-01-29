package org.apache.ibatis.executor;

import org.apache.ibatis.session.ResultHandler;

public interface Executor {

    //不需要ResultHandler
    ResultHandler NO_RESULT_HANDLER=null;
}
