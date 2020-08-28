package com.clickhouse.api.service;

import java.util.List;
import java.util.Map;

/**
 * clickHouse 公共服务接口
 *
 * @param <T>
 */
public interface ClickHouseService<T> {

    /**
     * 根据传入SQL条件，返回集合数据
     *
     * @param clazz
     * @param sql
     * @return
     */
    List<T> selectList(Class<T> clazz, String sql);

    /**
     * 根据传入SQL条件以及参数，返回集合数据
     *
     * @param clazz
     * @param sql
     * @param params
     * @return
     */
    List<T> selectList(Class<T> clazz, String sql, Object[] params);


    /**
     * 根据传入SQL条件以及参数，返回List对象Map集合数据
     *
     * @param sql
     * @param params
     * @return
     */
    List<Map<String, Object>> selectList(String sql, Object[] params);

    /**
     * 根据传入SQL条件，返回一条对象数据
     *
     * @param clazz
     * @param sql
     * @return
     */
    T selectInfo(Class<T> clazz, String sql);

    /**
     * 根据传入SQL条件以及参数，返回一条对象数据
     *
     * @param clazz
     * @param sql
     * @param params
     * @return
     */
    T selectInfo(Class<T> clazz, String sql, Object[] params);

    /**
     * 批量插入实体对象集合数据
     *
     * @param list
     * @param tableName
     */
    void batchInsert(List<T> list, String tableName);

    /**
     * 批量插入List对象集合map数据
     *
     * @param list
     * @param tableName
     */
    void batchInsertExt(List<Map<String, Object>> list, String tableName);

    /**
     * 根据传入SQL执行操作（如：删除表，删除数据，创建表）
     *
     * @param sql
     */
    void executeBySql(String sql);

}
