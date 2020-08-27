package com.kamluen.clickhouse.core.generator;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库表与java对象间的数据类型转换
 */
public class MappingUtil {

    private static final Map<String, String> DataTypeConvertMap = new HashMap<String, String>();

    static {
        init();
    }

    private static final void init() {

        /**
         *  Mysql dataType
         */
        DataTypeConvertMap.put("BIGINT", "Long");
        DataTypeConvertMap.put("CHAR", "String");
        DataTypeConvertMap.put("INT", "Integer");
        DataTypeConvertMap.put("FLOAT", "Float");
        DataTypeConvertMap.put("TIMESTAMP", "Date");
        DataTypeConvertMap.put("TIME", "Date");
        DataTypeConvertMap.put("VARCHAR", "String");
        DataTypeConvertMap.put("TEXT", "String");
        DataTypeConvertMap.put("BIT", "Integer");
        DataTypeConvertMap.put("BOOL", "Boolean");
        DataTypeConvertMap.put("TINYINT1", "Boolean");//boolean在MySQL里的类型为tinyint(1)
        DataTypeConvertMap.put("TINYINT4", "Integer");//如果tinyint(>1)标示int类型
        DataTypeConvertMap.put("SMALLINT", "Integer");
        DataTypeConvertMap.put("DOUBLE", "Double");
        DataTypeConvertMap.put("DECIMAL", "BigDecimal");


        /**
         * clickHouse dataType
         */
        DataTypeConvertMap.put("STRING", "String");
        DataTypeConvertMap.put("UINT8", "Integer");
        DataTypeConvertMap.put("UINT16", "Integer");
        DataTypeConvertMap.put("UINT32", "Integer");
        DataTypeConvertMap.put("UINT64", "Integer");
        DataTypeConvertMap.put("INT8", "Integer");
        DataTypeConvertMap.put("INT16", "Integer");
        DataTypeConvertMap.put("INT32", "Integer");
        DataTypeConvertMap.put("INT64", "Integer");
        DataTypeConvertMap.put("FLOAT32", "Double");
        DataTypeConvertMap.put("FLOAT64", "Double");

        /**
         * 公共的数据类型（即通用）
         */
        DataTypeConvertMap.put("BOOLEAN", "Boolean");
        DataTypeConvertMap.put("DECIMAL", "BigDecimal");
        DataTypeConvertMap.put("DATE", "Date");
        DataTypeConvertMap.put("DATETIME", "Date");
        DataTypeConvertMap.put("ENUM", "String");
    }

    /**
     * 获取java数据类型
     *
     * @param dataType
     * @return
     */
    public static final String getJavaType(String dataType) {
        String type = DataTypeConvertMap.get(dataType);
        if (type == null) {
            System.err.println("dataType = " + dataType);
            type = "String";
        }
        return type;
    }
}
