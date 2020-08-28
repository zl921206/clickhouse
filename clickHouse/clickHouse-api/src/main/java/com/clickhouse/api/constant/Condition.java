package com.clickhouse.api.constant;

/**
 * SQL相关操作关键字
 */
public class Condition {

    public static final String QUERY = " SELECT ";
    public static final String ADD = " INSERT INTO ";
    public static final String MODIFY = " UPDATE ";
    public static final String DELETE = " DELETE ";
    public static final String ALTER_TABLE = "ALTER TABLE ";

    /**
     * 通配符 * ，用于查询所有字段
     */
    public static final String WILDCARD = " * ";

    public static final String EQUAL = " = ";
    public static final String LESS = " < ";
    public static final String GREAT = " > ";
    public static final String GREAT_EQUAL = " >= ";
    public static final String LESS_EQUAL = " <= ";

    public static final String FROM = " FROM ";

    public static final String AND = " AND ";

    public static final String WHERE = " WHERE ";

    public static final String SORT = " ORDER BY ";

    public static final String DESC = " DESC ";

    public static final String LIMIT = " LIMIT ";

    public static final String COMMA = ",";

    /**
     * clickhouse cluster Name
     */
    public static final String CK_CLUSTER_NAME = " on cluster cluster_3shards_1replicas ";

    public static final String CK_TEST_CLUSTER_NAME = " on cluster singleton ";

}
