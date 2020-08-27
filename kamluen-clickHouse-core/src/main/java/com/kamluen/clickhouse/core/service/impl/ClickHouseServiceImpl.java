package com.kamluen.clickhouse.core.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kamluen.clickhouse.api.service.ClickHouseService;
import com.kamluen.clickhouse.core.handler.ClickHouseHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * clickhouse 服务实现类
 * @param <T>
 */
@Service(application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}",
        version = "${dubbo.version}")
@Component
public class ClickHouseServiceImpl<T> implements ClickHouseService<T> {

    @Resource
    private ClickHouseHandler clickHouseHandler;

    /**
     *  根据传入条件，返回集合数据 例：asset_id = "00700.HK" and date < "2019-01-01"
     * @param clazz
     * @param obj
     * @return list
     */
    @Override
    public List<T> selectList(Class<T> clazz, String sql) {
        return clickHouseHandler.selectList(clazz, sql);
    }

    /**
     * 根据传入条件，只可能返回一条数据 例：asset_id = "00700.HK" and date = "2019-01-01"
     * @param clazz
     * @param obj
     * @return Object
     */
    @Override
    public Object selectInfo(Class<T> clazz, String sql) {
        return clickHouseHandler.selectOne(clazz, sql);
    }

    /**
     * 批量插入集合数据
     * @param list
     * @param tableName
     */
    @Override
    public void batchInsert(List<T> list, String tableName) {
        clickHouseHandler.batchInsert(list, tableName);
    }

    /**
     * 根据传入SQL删除数据（如：删除表，删除数据，创建表）
     * @param sql
     */
    @Override
    public void executeBySql(String sql) {
        clickHouseHandler.executeBySql(sql);
    }

	@Override
	public List<T> selectList(Class<T> clazz, String sql, Object[] params) {
		return clickHouseHandler.selectList(clazz, sql, params);
	}

	@Override
	public Object selectInfo(Class<T> clazz, String sql, Object[] params) {
		return clickHouseHandler.selectOne(clazz, sql, params);
	}

	@Override
	public List<Map<String, Object>> selectList(String sql, Object[] params) {
		return clickHouseHandler.selectList(sql, params);
	}

	@Override
	public void batchInsertExt(List<Map<String, Object>> list, String tableName) {
		clickHouseHandler.batchInsertExt(list, tableName);
	}
}
