package org.apache.ibatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author :LiuYang
 * @desc
 * 类型处理器
 * @date :2021/1/31/031 16:58
 **/
public interface TypeHandler<T> {
    //设置参数
    void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

    //取得结果,供普通select用
    T getResult(ResultSet rs, String columnName) throws SQLException;

    //取得结果,供普通select用
    T getResult(ResultSet rs, int columnIndex) throws SQLException;

    //取得结果,供SP用
    T getResult(CallableStatement cs, int columnIndex) throws SQLException;
}
