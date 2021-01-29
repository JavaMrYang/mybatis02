package org.apache.ibatis.mapping;

import org.apache.ibatis.transaction.TransactionFactory;

import javax.sql.DataSource;

/**
 * 环境
 * 决定加载哪种环境(开发环境/生产环境)
 */
public final class Environment {

    private final String id;

    private final TransactionFactory transactionFactory;

    private final DataSource dataSource;

    public Environment(String id, TransactionFactory transactionFactory, DataSource dataSource) {
        if(id == null){
            throw new IllegalArgumentException("参数id必须不能为空!");
        }
        if (transactionFactory == null) {
            throw new IllegalArgumentException("Parameter 'transactionFactory' must not be null");
        }
        if (dataSource == null) {
            throw new IllegalArgumentException("Parameter 'dataSource' must not be null");
        }
        this.id = id;
        this.transactionFactory = transactionFactory;
        this.dataSource = dataSource;
    }

    //一个静态内部类Builder
    //建造模式
    //用法应该是new Environment.Builder(id).transactionFactory(xx).dataSource(xx).build();
    public static class Builder{
        private String id;
        private TransactionFactory transactionFactory;
        private DataSource dataSource;

        public Builder(String id) {
            this.id=id;
        }

        public Builder Builder(TransactionFactory transactionFactory) {
            this.transactionFactory = transactionFactory;
            return this;
        }

        public Builder dataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public String id() {
            return this.id;
        }
        //环境重新new了一个
        public Environment build() {
            return new Environment(this.id, this.transactionFactory, this.dataSource);
        }
    }

    public String getId() {
        return id;
    }

    public TransactionFactory getTransactionFactory() {
        return transactionFactory;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
