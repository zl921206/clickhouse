package com.clickhouse.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;

import javax.sql.DataSource;

/**
 * clickHouse数据源配置类
 * @author zhanglei
 */
@Configuration
public class ClickHouseDataSourceConfig {

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource clickHouseDataSource() {
        return DataSourceBuilder.create().driverClassName("ru.yandex.clickhouse.ClickHouseDriver").build();
    }

    /**
     * 定义日志过滤
     */
    private Slf4jLogFilter filter;

    @Bean
    public Slf4jLogFilter logFilter() {
        if (filter == null) {
            filter = new Slf4jLogFilter();
            filter.setDataSourceLogEnabled(false);
            filter.setResultSetLogEnabled(false);
            filter.setConnectionLogEnabled(false);
            filter.setStatementParameterClearLogEnable(false);
            filter.setStatementCreateAfterLogEnabled(false);
            filter.setStatementCloseAfterLogEnabled(false);
            filter.setStatementParameterSetLogEnabled(false);
            filter.setStatementPrepareAfterLogEnabled(false);
            filter.setStatementExecutableSqlLogEnable(true);
        }
        return filter;
    }

}
