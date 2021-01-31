package org.apache.ibatis.mapping;

import java.sql.ResultSet;

/**
 * @author :LiuYang
 * @desc
 * 结果集类型
 * @date :2021/1/31/031 16:52
 **/
public enum  ResultSetType {
    FORWARD_ONLY(ResultSet.TYPE_FORWARD_ONLY),
    SCROLL_INSENSITIVE(ResultSet.TYPE_SCROLL_INSENSITIVE),
    SCROLL_SENSITIVE(ResultSet.TYPE_SCROLL_SENSITIVE);

    int value;

    ResultSetType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
