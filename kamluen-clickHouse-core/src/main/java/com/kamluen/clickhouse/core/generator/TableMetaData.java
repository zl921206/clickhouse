package com.kamluen.clickhouse.core.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * clickHouse表结构对象
 *
 * @author zhanglei
 */
public class TableMetaData {

    /**
     * 表名
     */
    private String tableName;
    /**
     * 列属性封装对象
     */
    private List<TableMetaDataField> fields = new ArrayList<TableMetaDataField>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<TableMetaDataField> getFields() {
        return fields;
    }

    public void setFields(List<TableMetaDataField> fields) {
        this.fields = fields;
    }
}
