package org.apache.ibatis.exceptions;

public class ExecutorException extends PersistenceException{

    public ExecutorException(){
    }

    public ExecutorException(String message) {
        super(message);
    }

    public ExecutorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExecutorException(Throwable cause){
        super(cause);
    }
}
