package com.kamluen.clickhouse.api.service;

import java.util.List;
import java.util.Map;

/**
 * clickhouse 公共服务接口
 * @param <T>
 */
public interface ClickHouseService<T> {

    /**
     *  根据传入条件，返回集合数据 例：asset_id = "00700.HK" and date < "2019-01-01"
     * @param clazz
     * @param obj
     * @return list
     */
    List<T> selectList(Class<T> clazz, String sql);
    
    
    List<T> selectList(Class<T> clazz, String sql,Object[] params);
    
    
    List<Map<String,Object>> selectList(String sql,Object[] params);

    /**
     * 根据传入条件，只可能返回一条数据 例：asset_id = "00700.HK" and date = "2019-01-01"
     * @param clazz
     * @param obj
     * @return Object
     */
    Object selectInfo(Class<T> clazz, String sql);
    
    Object selectInfo(Class<T> clazz, String sql,Object[] params);

    /**
     * 批量插入集合数据
     * @param list
     * @param tableName
     */
    void batchInsert(List<T> list, String tableName);
    
    
    void batchInsertExt(List<Map<String,Object>> list, String tableName);

    /**
     * 根据传入SQL执行操作（如：删除表，删除数据，创建表）
     * @param sql
     */
    void executeBySql(String sql);

}
