package com.kamluen.clickhouse.core.generator;

/**
 * clickHouse 表结构字段对象
 */
public class TableMetaDataField {

    /**
     * clickHouse 表名
     */
    private String tableName;
    /**
     * clickHouse 表字段类型
     */
    private String type;
    /**
     * clickHouse 表字段注释
     */
    private String comment;
    /**
     * clickHouse 表字段名
     */
    private String name;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
