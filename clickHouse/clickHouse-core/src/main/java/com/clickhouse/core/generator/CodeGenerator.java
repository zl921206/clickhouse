package com.clickhouse.core.generator;

import java.util.List;

/**
 * 代码生成执行器
 */
public class CodeGenerator {

    public static void execute(String domain, String outputDir, String dbName, List<String> tableName) {
        new MetaUtil().execute(domain, outputDir, dbName, tableName);
    }
}
