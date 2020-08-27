package com.kamluen.clickhouse.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * @author zhanglei
 */
@Configuration
public class ClickHouseDataSourceConfig {
    private static final Logger log = LoggerFactory.getLogger(ClickHouseDataSourceConfig.class);

//    @Bean(name="clickHouseDataSource")
//    @ConfigurationProperties(prefix = "spring.clickhouse")
//    public DataSource clickHouseDataSource() {
//        final DataSource dataSource = DataSourceBuilder.create().driverClassName("ru.yandex.clickhouse.ClickHouseDriver").build();
//        return dataSource;
//    }

    @Primary
    @Bean(name = "clickHouse_ds01")
    @ConfigurationProperties(prefix = "spring.datasource.hadoop01")
    public DataSource dataSourceOne() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        List<Filter> list = new ArrayList<Filter>() {
        };
        list.add(logFilter());
        druidDataSource.setProxyFilters(list);
        return druidDataSource;
    }

    @Bean(name = "clickHouse_ds02")
    @ConfigurationProperties(prefix = "spring.datasource.hadoop02")
    public DataSource dataSourceTwo() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        List<Filter> list = new ArrayList<Filter>() {
        };
        list.add(logFilter());
        druidDataSource.setProxyFilters(list);
        return druidDataSource;
    }

    @Bean(name = "clickHouse_ds03")
    @ConfigurationProperties(prefix = "spring.datasource.hadoop03")
    public DataSource dataSourceThree() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        List<Filter> list = new ArrayList<Filter>() {
        };
        list.add(logFilter());
        druidDataSource.setProxyFilters(list);
        return druidDataSource;
    }

    Slf4jLogFilter filter;

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
