package com.clickhouse.core.generator;

import java.sql.*;

/**
 * 数据库连接实体Util
 */
public class DBUtil {

    public static String URL;
    public static String USERNAME;
    public static String PASSWORD;
    public static String DIREVER;
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
