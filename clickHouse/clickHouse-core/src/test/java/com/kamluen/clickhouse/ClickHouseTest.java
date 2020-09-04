package com.kamluen.clickhouse;

import com.alibaba.fastjson.JSONObject;
import com.clickhouse.api.constant.Condition;
import com.clickhouse.api.service.ClickHouseService;
import com.clickhouse.core.ClickHouseApplication;
import com.clickhouse.core.handler.ClickHouseHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClickHouseApplication.class)
public class ClickHouseTest<T> {

    @Resource
    private ClickHouseService clickHouseService;

    @Resource
    ClickHouseHandler clickHouseHandler;

    /**
     * 集合数据查询测试
     */
    @Test
    public void selectList(){
        String sql = "select * from digital_currency.t_trade limit 5";
        // 返回实体对象list集合数据
//        List<TTrade> list = clickHouseHandler.selectList(TTrade.class, sql);
        // 返回map集合对象list集合数据
        List<Map<String, Object>> maps = clickHouseHandler.selectList(sql, new Object[]{});
        System.out.println("输出集合数据：" + JSONObject.toJSONString(maps));
    }


    /**
     * 删除测试
     */
    @Test
    public void deleteTest(){
        String tableName = "";
        String assetId = "zhanglei.SZ";
        String deleteSql = Condition.ALTER_TABLE + tableName + Condition.CK_CLUSTER_NAME + Condition.DELETE + Condition.WHERE + " asset_id = '%s'";
        deleteSql = String.format(deleteSql, assetId);
        System.out.println("打印执行SQL：" + deleteSql);
        clickHouseService.executeBySql(deleteSql);
        System.out.println("执行deleteTest()方法完成.....");
    }

}
