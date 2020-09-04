package com.clickhouse.core.generator;

import java.sql.*;

/**
 * 数据库连接实体Util
 */
public class DBUtil {

    /**
     * 数据库连接URL
     */
    public static String URL;
    /**
     * 数据库连接用户名
     */
    public static String USERNAME;
    /**
     * 数据库连接密码
     */
    public static String PASSWORD;
    /**
     * 驱动
     */
    public static String DIREVER;
    /**
     * 是否加载驱动标记
     */
    private static boolean loadDriver;

    static void loadDriver() {
        try {
            //加载驱动
            Class.forName(DIREVER);
            loadDriver = true;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Connection getConnection() {
        if (!loadDriver) {
            loadDriver();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static final void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
