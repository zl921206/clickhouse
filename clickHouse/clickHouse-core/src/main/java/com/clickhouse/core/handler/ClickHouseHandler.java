package com.clickhouse.core.handler;

import com.clickhouse.api.constant.Condition;
import com.clickhouse.api.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.sql.DataSource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * @author zhanglei
 * @date 2019-04-15
 * @desc clickHouse连接配置信息处理类
 */
@Slf4j
@Component
public class ClickHouseHandler<T> {

    /**
     * 注入数据源
     */
    @Resource(name = "dataSource")
    private DataSource clickHouseDatasource;

    /**
     * 获取创建CK连接
     *
     * @return
     * @throws SQLException
     */
    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = clickHouseDatasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("连接clickHouse服务异常：{}", e.getMessage());
        }
        return connection;
    }

    /**
     * 根据传入SQL条件，查询对象集合数据
     *
     * @param clazz
     * @param sql
     * @return
     */
    public List<T> selectList(Class<T> clazz, String sql) {
        log.info("clickHouse 查询集合数据执行sql：" + sql);
        Statement statement = null;
        ResultSet results = null;
        Connection conn = null;
        try {
            conn = getConnection();
            statement = conn.createStatement();
            results = statement.executeQuery(sql.toString());
            List<T> list = mapResultSetToObject(results, clazz);
            if (list != null) {
                log.debug("查询出数据size：{}", list.size());
            } else {
                log.debug("ResultSet is empty. Please check if database table is empty");
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {//关闭连接
            close(statement, conn, results);
        }
        return null;
    }

    /**
     * 添加传入参数
     *
     * @param statement
     * @param params
     * @throws SQLException
     */
    private void putParams(PreparedStatement statement, Object[] params) throws SQLException {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof Integer) {
                    statement.setInt(i + 1, (Integer) params[i]);
                } else if (params[i] instanceof Long) {
                    statement.setLong(i + 1, (Long) params[i]);
                } else if (params[i] instanceof String) {
                    statement.setString(i + 1, params[i].toString());
                } else if (params[i] instanceof Double) {
                    statement.setDouble(i + 1, (Double) params[i]);
                } else if (params[i] instanceof BigDecimal) {
                    statement.setBigDecimal(i + 1, (BigDecimal) params[i]);
                } else if (params[i] instanceof Float) {
                    statement.setFloat(i + 1, (Float) params[i]);
                } else {
                    statement.setObject(i + 1, params);
                }
            }
        }
    }

    /**
     * 根据传入SQL条件以及参数，查询集合数据
     *
     * @param clazz
     * @param sql
     * @param params
     * @return
     */
    public List<T> selectList(Class<T> clazz, String sql, Object[] params) {
        log.info("clickHouse 查询集合数据执行sql：" + sql);
        PreparedStatement statement = null;
        ResultSet results = null;
        Connection conn = null;
        try {
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            putParams(statement, params);
            results = statement.executeQuery();
            List<T> list = mapResultSetToObject(results, clazz);
            if (list != null) {
                log.debug("查询出数据size：{}", list.size());
            } else {
                log.debug("ResultSet is empty. Please check if database table is empty");
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {//关闭连接
            close(statement, conn, results);
        }
        return null;
    }

    /**
     * 根据传入SQL条件以及参数，返回List对象Map集合数据
     *
     * @param sql
     * @param params
     * @return
     */
    public List<Map<String, Object>> selectList(String sql, Object[] params) {
        log.info("clickHouse 查询集合数据执行sql：" + sql);
        PreparedStatement statement = null;
        ResultSet results = null;
        Connection conn = null;
        try {
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            putParams(statement, params);
            results = statement.executeQuery();
            List<Map<String, Object>> list = mapResultSet(results);
            if (list != null) {
                log.debug("查询出数据size：{}", list.size());
            } else {
                log.debug("ResultSet is empty. Please check if database table is empty");
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {//关闭连接
            close(statement, conn, results);
        }
        return null;
    }

    /**
     * 根据传入SQL条件，返回一条对象数据
     *
     * @param clazz
     * @param sql
     * @return
     */
    public T selectOne(Class<T> clazz, String sql) {
        log.info("clickHouse 查询单条数据执行sql：" + sql);
        Statement statement = null;
        ResultSet results = null;
        Connection conn = null;
        try {
            conn = getConnection();
            statement = conn.createStatement();
            results = statement.executeQuery(sql.toString());
            if (Number.class.isAssignableFrom(clazz) || Date.class.isAssignableFrom(clazz) ||
                    String.class.isAssignableFrom(clazz)) {
                if (results.next()) {
                    return (T) results.getObject(1);
                }
            } else {
                List<T> list = mapResultSetToObject(results, clazz);
                return list == null || list.size() == 0 ? null : list.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {//关闭连接
            close(statement, conn, results);
        }
        return null;
    }

    /**
     * 根据传入SQL条件以及参数，返回一条对象数据
     *
     * @param clazz
     * @param sql
     * @param params
     * @return
     */
    public T selectOne(Class<T> clazz, String sql, Object[] params) {
        log.info("clickHouse 查询单条数据执行sql：" + sql);
        PreparedStatement statement = null;
        ResultSet results = null;
        Connection conn = null;
        try {
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            putParams(statement, params);
            results = statement.executeQuery();
            if (Number.class.isAssignableFrom(clazz) || Date.class.isAssignableFrom(clazz) ||
                    String.class.isAssignableFrom(clazz)) {
                if (results.next()) {
                    return (T) results.getObject(1);
                }
            } else {
                List<T> list = mapResultSetToObject(results, clazz);
                return list == null || list.size() == 0 ? null : list.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {//关闭连接
            close(statement, conn, results);
        }
        return null;
    }

    /**
     * 批量插入实体对象集合数据
     *
     * @param list
     * @param tableName
     */
    public void batchInsert(List<T> list, String tableName) {
        if (list == null || list.size() <= 0 || StringUtil.isEmpty(tableName))
            return;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Field> fieldList = new ArrayList<>();
        Field[] fields = null;
        int fieldSize = 0;
        Connection conn = null;
        try {
            Long startTime = System.currentTimeMillis();
            // 此处查询一次，只为了获取对应列名索引，进而插入对应值
            conn = getConnection();
            resultSet = conn.createStatement().executeQuery(Condition.QUERY + Condition.WILDCARD + Condition.FROM + tableName + Condition.LIMIT + 1);
            Map<String, Integer> indexMap = new HashMap<>();
            // 将列名和对应索引存入indexMap
            for (int a = 1; a <= resultSet.getMetaData().getColumnCount(); a++) {
                indexMap.put(resultSet.getMetaData().getColumnName(a), a);
            }
            int batch = 0;
            for (T obj : list) {
                batch++;
                if (null == fields || fieldSize == 0) {
                    StringBuffer sql = new StringBuffer(Condition.ADD + tableName + " values(");
                    Class clazz = obj.getClass();
                    while (clazz != null) {   //当父类为null的时候说明到达了最上层的父类(Object类).
                        fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
                        clazz = clazz.getSuperclass(); //得到父类,然后赋给自己
                    }
                    fields = fieldList.toArray(new Field[fieldList.size()]);
                    fieldSize = fields.length;
                    for (int i = 0; i < fieldSize; i++) {
                        if (!fields[i].isAnnotationPresent(Column.class)) {
                            continue;
                        }
                        if (fields[i].getAnnotation(Column.class) == null) {
                            continue;
                        }
                        sql.append("?,");
                    }
                    sql.deleteCharAt(sql.length() - 1);
                    sql.append(")");
                    ps = conn.prepareStatement(sql.toString());
                    log.info("批量插入" + tableName + "打印执行sql: " + sql);
                }

                for (int j = 0; j < fieldSize; j++) {
                    fields[j].setAccessible(true);
                    if (!fields[j].isAnnotationPresent(Column.class)) {
                        continue;
                    }
                    if (fields[j].getAnnotation(Column.class) == null) {
                        continue;
                    }
                    // 获取当前需要插入的列名
                    String columnName = fields[j].getAnnotation(Column.class).name();
                    // 将value set到对应的列位
                    if (StringUtil.isNotNull(fields[j].get(obj))) {
                        if (resultSet.getMetaData().getColumnType(indexMap.get(columnName)) == Types.TIMESTAMP) {
                            if (fields[j].get(obj) instanceof Timestamp) {
                                ps.setTimestamp(indexMap.get(columnName), (Timestamp) fields[j].get(obj));
                            } else if (fields[j].get(obj) instanceof Date) {
                                ps.setTimestamp(indexMap.get(columnName), new java.sql.Timestamp(((Date) fields[j].get(obj)).getTime()));
                            } else {
                                ps.setTimestamp(indexMap.get(columnName), null);
                            }
                        } else if (resultSet.getMetaData().getColumnType(indexMap.get(columnName)) == Types.DATE) {
                            if (fields[j].get(obj) instanceof java.sql.Date) {
                                ps.setDate(indexMap.get(columnName), (java.sql.Date) fields[j].get(obj));
                            } else if (fields[j].get(obj) instanceof Date) {
                                ps.setDate(indexMap.get(columnName), new java.sql.Date(((Date) fields[j].get(obj)).getTime()));
                            } else if (fields[j].get(obj) instanceof String) {
                                ps.setString(indexMap.get(columnName), fields[j].get(obj).toString());
                            } else {
                                ps.setDate(indexMap.get(columnName), null);
                            }
                        } else if (resultSet.getMetaData().getColumnType(indexMap.get(columnName)) == Types.DECIMAL) {
                            if (fields[j].get(obj) instanceof BigDecimal) {
                                ps.setBigDecimal(indexMap.get(columnName), (BigDecimal) fields[j].get(obj));
                            } else if (fields[j].get(obj) instanceof String) {
                                ps.setBigDecimal(indexMap.get(columnName), new BigDecimal(fields[j].get(obj).toString()));
                            } else if (fields[j].get(obj) instanceof Number) {
                                ps.setBigDecimal(indexMap.get(columnName), BigDecimal.valueOf((Double) fields[j].get(obj)));
                            } else {
                                ps.setBigDecimal(indexMap.get(columnName), null);
                            }
                        } else {
                            ps.setObject(indexMap.get(columnName), fields[j].get(obj));
                        }
                    } else {
                        ps.setObject(indexMap.get(columnName), null);
                    }
                }
                ps.addBatch();
                // 每2000插入一次
                if (batch % 2000 == 0) {
                    ps.executeBatch();
                }
            }
            // 插入剩余数量不足2000的
            ps.executeBatch();
            indexMap = null;
            Long endTime = System.currentTimeMillis();
            log.info("集合size：{}，批量插入{}成功,耗时{}ms......", list.size(), tableName, (endTime - startTime));
        } catch (Exception e1) {
            log.error("集合size：{}，批量插入{}异常：{}", list.size(), tableName, e1.getMessage());
        } finally {
            close(ps, conn, resultSet);
        }
    }

    /**
     * 批量插入List对象集合map数据
     *
     * @param list
     * @param tableName
     */
    public void batchInsertExt(List<Map<String, Object>> list, String tableName) {
        if (list == null || list.size() <= 0 || StringUtil.isEmpty(tableName))
            return;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String[] fields = null;
        int fieldSize = 0;
        Connection conn = null;
        try {
            Long startTime = System.currentTimeMillis();
            // 此处查询一次，只为了获取对应列名索引，进而插入对应值
            conn = getConnection();
            resultSet = conn.createStatement().executeQuery(Condition.QUERY + Condition.WILDCARD + Condition.FROM + tableName + Condition.LIMIT + 1);
            Map<String, Integer> indexMap = new HashMap<>();
            // 将列名和对应索引存入indexMap
            for (int a = 1; a <= resultSet.getMetaData().getColumnCount(); a++) {
                indexMap.put(resultSet.getMetaData().getColumnName(a), a);
            }
            int batch = 0;
            Object value;
            for (Map<String, Object> map : list) {
                batch++;
                if (null == fields || fieldSize == 0) {
                    StringBuffer sql = new StringBuffer(Condition.ADD + tableName + " (");
                    fields = map.keySet().toArray(new String[map.keySet().size()]);
                    fieldSize = fields.length;
                    for (int i = 0; i < fieldSize; i++) {
                        sql.append(fields[i] + ",");
                    }
                    sql.deleteCharAt(sql.length() - 1);
                    sql.append(") values(");
                    for (int i = 0; i < fieldSize; i++) {
                        sql.append("?,");
                    }
                    sql.deleteCharAt(sql.length() - 1);
                    sql.append(")");
                    ps = conn.prepareStatement(sql.toString());
                    log.info("批量插入" + tableName + "打印执行sql: " + sql);
                }
                for (int j = 0; j < fieldSize; j++) {
                    // 获取当前需要插入的列名
                    value = map.get(fields[j]);
                    // 将value set到对应的列位
                    if (value instanceof Integer) {
                        ps.setInt(j + 1, (Integer) value);
                    } else if (value instanceof Long) {
                        ps.setLong(j + 1, (Long) value);
                    } else if (value instanceof String) {
                        ps.setString(j + 1, value.toString());
                    } else if (value instanceof Double) {
                        ps.setDouble(j + 1, (Double) value);
                    } else if (value instanceof BigDecimal) {
                        ps.setBigDecimal(j + 1, (BigDecimal) value);
                    } else if (value instanceof Float) {
                        ps.setFloat(j + 1, (Float) value);
                    } else {
                        ps.setObject(j + 1, value);
                    }
                }
                ps.addBatch();
                // 每2000插入一次
                if (batch % 2000 == 0) {
                    ps.executeBatch();
                }
            }
            // 插入剩余数量不足2000的
            ps.executeBatch();
            indexMap = null;
            Long endTime = System.currentTimeMillis();
            log.info("集合size：{}，批量插入{}成功,耗时{}ms......", list.size(), tableName, (endTime - startTime));
        } catch (Exception e1) {
            log.error("集合size：{}，批量插入{}异常：{}", list.size(), tableName, e1);
        } finally {
            close(ps, conn, resultSet);
        }
    }

    /**
     * 根据传入SQL做执行操作（如：删除表，删除数据，创建表）
     *
     * @param sql
     */
    public void executeBySql(String sql) {
        log.info("clickhouse 输出执行sql：" + sql);
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            if (count > 0) {
                log.info("执行成功！");
            } else {
                log.info("执行失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {//关闭连接
            close(stmt, conn, null);
        }
    }

    /**
     * 将查询的返回结果信息封装实体对象
     *
     * @param rs
     * @param outputClass
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> mapResultSetToObject(ResultSet rs, Class outputClass) {
        List<T> outputList = null;
        try {
            // make sure resultset is not null
            if (rs != null) {
                // check if outputClass has 'Entity' annotation
                if (outputClass.isAnnotationPresent(Entity.class)) {
                    // get the resultset metadata
                    ResultSetMetaData rsmd = rs.getMetaData();
                    // get all the attributes of outputClass
//                    Field[] fields = outputClass.getDeclaredFields();
                    Class currClass = outputClass;
                    List<Field> fields = new ArrayList<>();
                    while (outputClass != null) {   //当父类为null的时候说明到达了最上层的父类(Object类).
                        fields.addAll(Arrays.asList(outputClass.getDeclaredFields()));
                        outputClass = outputClass.getSuperclass(); //得到父类,然后赋给自己
                    }
                    while (rs.next()) {
                        T bean = (T) currClass.newInstance();
                        for (int _iterator = 0; _iterator < rsmd.getColumnCount(); _iterator++) {
                            // getting the SQL column name
                            String columnName = rsmd.getColumnName(_iterator + 1);
                            // reading the value of the SQL column
                            Object columnValue = rs.getObject(_iterator + 1);
                            // iterating over outputClass attributes to check if
                            // any attribute has 'Column' annotation with
                            // matching 'name' value
                            for (Field field : fields) {
                                if (field.isAnnotationPresent(Column.class)) {
                                    Column column = field.getAnnotation(Column.class);
                                    if (column.name().equalsIgnoreCase(columnName) && columnValue != null) {
                                        BeanUtils.setProperty(bean, field.getName(), columnValue);
                                        break;
                                    }
                                }
                            }
                        }
                        if (outputList == null) {
                            outputList = new ArrayList<T>();
                        }
                        outputList.add(bean);
                    }
                } else {
                    // throw some error
                }
            } else {
                return null;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return outputList;
    }


    /**
     * 返回结果数据封装成List对象map集合格式返回
     *
     * @param rs
     * @return
     */
    public List<Map<String, Object>> mapResultSet(ResultSet rs) {
        List<Map<String, Object>> outputList = null;
        try {
            if (rs != null) {
                ResultSetMetaData rsmd = rs.getMetaData();
                Map<String, Object> resultMap;
                while (rs.next()) {
                    resultMap = new HashMap<>();
                    for (int _iterator = 0; _iterator < rsmd.getColumnCount(); _iterator++) {
                        resultMap.put(rsmd.getColumnName(_iterator + 1), rs.getObject(_iterator + 1));
                    }
                    if (outputList == null) {
                        outputList = new ArrayList<Map<String, Object>>();
                    }
                    outputList.add(resultMap);
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputList;
    }

    /**
     * 关闭流公共处理
     *
     * @param stmt
     * @param conn
     * @param resultSet
     */
    public void close(Statement stmt, Connection conn, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
