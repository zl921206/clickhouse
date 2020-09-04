package com.kamluen.clickhouse;

import com.clickhouse.core.generator.CodeGenerator;
import com.clickhouse.core.generator.DBUtil;

import java.util.Arrays;

/**
 * 代码生成测试类
 */
public class CodeGenTest {

    /**
     * 定义clickHouse数据库连接参数
     */
    public static String URL = "jdbc:clickhouse://127.0.0.1:8123";
    public static String USERNAME = "default";
    public static String PASSWORD = "123456";
    public static String DIREVER = "ru.yandex.clickhouse.ClickHouseDriver";


    public static void main(String[] args) {
        DBUtil.URL = URL;
        DBUtil.USERNAME = USERNAME;
        DBUtil.PASSWORD = PASSWORD;
        DBUtil.DIREVER = DIREVER;
        CodeGenerator.execute("com.clickhouse.api", "clickHouse-api", "digital_currency", Arrays.asList("t_trade"));
    }
}
