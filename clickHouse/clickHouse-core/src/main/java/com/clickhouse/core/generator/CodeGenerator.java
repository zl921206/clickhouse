package com.clickhouse.core.generator;

import java.util.List;

/**
 * @author zhanglei
 * @desc clickHouse 实体类代码生成执行器
 */
public class CodeGenerator {

    /**
     * 实体类生成
     * @param domain    包路径
     * @param outputDir 输入到当前工程下文件夹
     * @param dbName    数据库名称
     * @param tableName 表名，可以定义多个表
     */
    public static void execute(String domain, String outputDir, String dbName, List<String> tableName) {
        new MetaUtil().execute(domain, outputDir, dbName, tableName);
    }
}
