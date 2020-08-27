package com.kamluen.clickhouse.core.generator;

import org.springframework.util.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据转换处理Util
 */
public class MetaUtil {

    /**
     * sql 转 java 字段集合
     */
    private static final Map<String, String> sql2JavafieldMap = new ConcurrentHashMap<String, String>();
    /**
     * java 转 sql 字段集合
     */
    private static final Map<String, String> java2SqlfieldMap = new ConcurrentHashMap<String, String>();

    /**
     * 首字母大写
     *
     * @param value
     * @return
     */
    public static final String firstUpString(String value) {
        if (value.length() == 1) {
            return value.toUpperCase();
        } else if (value.length() >= 2) {
            return value.substring(0, 1).toUpperCase() + value.substring(1);
        } else {
            return value;
        }
    }

    /**
     * 生成get set 方法
     *
     * @param writer
     * @param type
     * @param fieldName
     * @throws IOException
     */
    public static final void genGetterAndSetter(BufferedWriter writer, String type, String fieldName)
            throws IOException {
        writer.newLine();
        writer.write("    public " + type + " get" + firstUpString(fieldName) + " () {");
        writer.newLine();
        writer.write("        return " + fieldName + ";");
        writer.newLine();
        writer.write("    }");
        writer.newLine();

        writer.newLine();
        writer.write("    public void set" + firstUpString(fieldName) + " (" + type + " " + fieldName + ") {");
        writer.newLine();
        writer.write("        this." + fieldName + " = " + fieldName + ";");
        writer.newLine();
        writer.write("    }");
        writer.newLine();
    }

    /**
     * 获取传入的clickHouse表结构字段信息数据
     *
     * @param dbName
     * @param tableName
     * @return
     */
    public final TableMetaData getMetaData(String dbName, String tableName) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            stmt = conn.createStatement();

            // clickhouse 查看表结构sql
            rs = stmt.executeQuery("desc " + dbName + "." + tableName);

            TableMetaData data = new TableMetaData();
            data.setTableName(tableName);
            while (rs.next()) {
                TableMetaDataField field = new TableMetaDataField();
                field.setName(rs.getString("name"));
                field.setType(rs.getString("type"));
                field.setTableName(tableName);
                data.getFields().add(field);
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, stmt, rs);
        }
    }

    /**
     * 根据表结构中列的数据类型获取java数据类型
     *
     * @param type
     * @return
     */
    public static final String getJavaType(TableMetaDataField type) {
        String dataType = type.getType();
        if (dataType.contains("(")) {
            dataType = dataType.substring(dataType.indexOf('(') + 1, dataType.indexOf(')'));
        }
        dataType = dataType.toUpperCase();

        return MappingUtil.getJavaType(dataType);
    }

    /**
     * 代码生成处理
     *
     * @param domain
     * @param outputDir
     * @param dbName
     * @param tableName
     */
    public final void execute(String domain, String outputDir, String dbName, List<String> tableName) {
        String[] tableNames = null;
        try {
            if (!StringUtils.hasText(outputDir)) {
                outputDir = System.getProperty("user.dir");
            }
            if (tableNames == null || tableNames.length == 0) {
                tableNames = new String[]{};
                tableNames = getTableNames().toArray(tableNames);
            }

            System.err.println("===================== AutoGenCode start ========================");
            for (String tName : tableNames) {
                if (tableName.contains(tName)) {
                    genPoClassFromTable(domain, dbName, tName, getClassName(tName.trim()), outputDir);
                }
            }
            System.err.println("===================== AutoGenCode end ========================");
        } catch (Exception e) {
            throw new RuntimeException("", e);
        }
    }

    /**
     * 获取类名
     *
     * @param tableName
     * @return
     */
    private final String getClassName(String tableName) {
        return firstUpString(getSql2JavaField(tableName.trim()));
    }

    /**
     * 先删除目录下的类
     */
    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    /**
     * 获取数据库表名
     *
     * @return
     */
    public static List<String> getTableNames() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //show full fields from car_info;
            conn = DBUtil.getConnection();
            DatabaseMetaData dbmd = conn.getMetaData();
            rs = dbmd.getTables(null, null, "%", new String[]{"TABLE"});
            List<String> tableNames = new ArrayList<String>();
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME"); //表名
                tableNames.add(tableName);
            }
            return tableNames;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, stmt, rs);
        }
    }

    /**
     * 根据表结构列生成表实体对象
     *
     * @param domain
     * @param dbName
     * @param tableName
     * @param className
     * @param outputDir
     * @throws Exception
     */
    private final void genPoClassFromTable(String domain, String dbName, String tableName, String className, String outputDir)
            throws Exception {
        TableMetaData md = getMetaData(dbName, tableName);
        File destDir = new File(outputDir + "/src/main/java/" + domain.replace(".", "/") + "/entity/");
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(destDir + "/" + className + ".java"));
        writer.write("package " + domain + ".entity;");
        writer.newLine();

        // 导入 注解类
        writer.write("import javax.persistence.Column;");
        writer.newLine();
        writer.write("import javax.persistence.Entity;");
        writer.newLine();

        // 导入 lombok
        writer.write("import lombok.Data;");
        writer.newLine();

        writer.write("import java.io.Serializable;");
        writer.newLine();

        boolean containsBigDecimal = false;// 防止重复引入
        for (TableMetaDataField f : md.getFields()) {
            if (!containsBigDecimal && getJavaType(f).equalsIgnoreCase("BigDecimal")) {
                writer.write("import java.math.BigDecimal;");
                writer.newLine();
                containsBigDecimal = true;
            }
        }

        boolean containsDate = false;// 防止重复引入
        for (TableMetaDataField f : md.getFields()) {
            if (!containsDate &&
                    (f.getType().equalsIgnoreCase("datetime") || f.getType().equalsIgnoreCase("date") || f.getType().equalsIgnoreCase("time") ||
                            f.getType().equalsIgnoreCase("timestamp"))) {
                writer.write("import java.util.Date;");
                writer.newLine();
                containsDate = true;
            }
        }
        writer.newLine();

        // 导入注解
        writer.write("@Entity");
        writer.newLine();
        writer.write("@Data");
        writer.newLine();

        writer.write("public class " + className + " implements Serializable {");
        writer.newLine();
        writer.newLine();
        writer.write("	private static final long serialVersionUID = -2260388125919493487L;");
        writer.newLine();

        try {
            for (TableMetaDataField f : md.getFields()) {
                String comment = f.getComment();
                String javaType = getJavaType(f);
                String javaField = getSql2JavaField(f.getName());
                Object defVal = "";
                String defaultValue = "";
                if (comment != null && comment.length() > 0) {
                    writer.write("	@Column(name = " + "\"" + f.getName() + "\"" + ")");
                    writer.newLine();
                    writer.write("	private " + javaType + " " + javaField + defaultValue + ";//" + comment);
                } else {
                    writer.write("	@Column(name = " + "\"" + f.getName() + "\"" + ")");
                    writer.newLine();
                    writer.write("	private " + javaType + " " + javaField + defaultValue + ";");
                }
                writer.newLine();
            }

            /**
             * 自动生成get set 方法去除，因为已经导入了 lombok
             */
//            for (TableMetaDataField f : md.getFields()) {
//                String javaType = getJavaType(tableName, f);
//                String javaField = DB4JUtil.getSql2JavaField(f.getField());
//                genGetterAndSetter(writer, javaType, javaField);
//            }
            writer.write("}");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            writer.flush();
            writer.close();
        }
    }


    /**
     * 表字段转换为实体对象属性
     * 如果字段全是大写的.比如字段INNER_CODE,则在反向到java对象时也是INNER_CODE
     */
    public static final String getSql2JavaField(String sqlField) {
        if (org.apache.commons.lang.StringUtils.isEmpty(sqlField)) {
            throw new RuntimeException("sql field to java field error.");
        }
        String javaField = sql2JavafieldMap.get(sqlField);
        if (javaField != null) {
            return javaField;
        }
        char[] chars = sqlField.toCharArray();
        int isUpperCase = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            //如果是大写字母或者数字
            if (isUpperEnglishChar(chars[i]) || isNumberChar(chars[i])) {
                isUpperCase += 1;
            }
            if ('_' == c && i < chars.length - 1) {
                if (isLowerEnglishChar(chars[i + 1])) {
                    chars[i + 1] = (char) (chars[i + 1] - 32);
                }
            }
        }
        String dest = new String(chars);
        javaField = dest.replace("_", "");
        //如果全是大写字母加数字则不用驼峰格式化
        if (javaField.length() == isUpperCase) {
            javaField = sqlField;
        }
        sql2JavafieldMap.put(sqlField, javaField);
        return javaField;
    }

    /**
     * 实体对象属性转换为表字段
     */
    public static final String getJava2SqlField(String javaField) {
        if (org.apache.commons.lang.StringUtils.isEmpty(javaField)) {
            throw new RuntimeException("java field to sql field error.");
        }
        String sqlField = java2SqlfieldMap.get(javaField);
        if (sqlField != null) {
            return sqlField;
        }
        char[] chars = javaField.toCharArray();
        int count = 0;
        //判断整个java属性是否都是大写
        int isUpperCase = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            //如果是数字
            if (isNumberChar(c)) {
                isUpperCase += 1;
            }
            //如果大写字母
            if (isUpperEnglishChar(c)) {
                isUpperCase += 1;
                count += 2;
            } else {
                count++;
            }
        }

        //如果全部是大写或者数字则返回和数据库一样的属性名称
        if (javaField.replace("_", "").length() == isUpperCase) {
            java2SqlfieldMap.put(javaField, javaField);
            return javaField;
        }

        char[] dest = new char[count];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z') {
                count += 2;
                dest[index++] = '_';
                dest[index++] = (char) (c + 32);
            } else {
                dest[index++] = c;
            }
        }
        sqlField = new String(dest);
        java2SqlfieldMap.put(javaField, sqlField);
        return sqlField;
    }

    /**
     * 是否小写的英文字母
     *
     * @param value
     * @return
     */
    private static final boolean isLowerEnglishChar(char value) {
        return (value >= 'a' && value <= 'z');
    }

    /**
     * 是否大写的英文字母
     *
     * @param value
     * @return
     */
    private static final boolean isUpperEnglishChar(char value) {
        return (value >= 'A' && value <= 'Z');
    }

    /**
     * 是否是数字
     *
     * @param value
     * @return
     */
    private static final boolean isNumberChar(char value) {
        return (value >= '0' && value <= '9');
    }
}
