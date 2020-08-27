package com.kamluen.clickhouse;

import com.alibaba.fastjson.JSONObject;
import com.kamluen.clickhouse.api.constant.ColumnName;
import com.kamluen.clickhouse.api.constant.Condition;
import com.kamluen.clickhouse.api.constant.TableName;
import com.kamluen.clickhouse.api.entity.*;
import com.kamluen.clickhouse.api.entity.jydb.AdjFactor;
import com.kamluen.clickhouse.api.entity.kamluen.UserOperateLog;
import com.kamluen.clickhouse.api.entity.news.NewsCount;
import com.kamluen.clickhouse.api.entity.news.SpLabelNews;
import com.kamluen.clickhouse.api.service.ClickHouseService;
import com.kamluen.clickhouse.core.ClickHouseApplication;
import com.kamluen.clickhouse.core.handler.ClickHouseHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClickHouseApplication.class)
public class ClickHouseTest<T> {

    @Resource
    private ClickHouseService clickHouseService;

    @Resource
    ClickHouseHandler clickHouseHandler;

    /**
     * 查询集合数据测试
     */
    @Test
    public void queryTestInfo() {
        String date = "2019-05-31";
        String groupSql = "select hk.* from (select * from "+TableName.CK_HK_DAILY_ALL+") hk left join (select asset_id,max(`date`) as maxDate from "+TableName.CK_HK_DAILY_ALL+" where `date` <= '%s' group by asset_id) t on hk.asset_id = t.asset_id where hk.`date` = t.maxDate limit 1";
        groupSql = String.format(groupSql,date);
        List<StkDayHk> result = clickHouseService.selectList(StkDayHk.class , groupSql);
        result.forEach(info -> System.out.println("输出对象信息：" + JSONObject.toJSONString(info)));
    }

    /**
     * 查询单条数据测试
     */
    @Test
    public void selectTest(){
        String queryColumn = "*";
        String assetId = "zhanglei.SZ";
        String date = "2019-04-29";
        int limit = 5;
        String querySql = Condition.QUERY + queryColumn + Condition.FROM + "%s" + Condition.WHERE + ColumnName.ASSET_ID + Condition.EQUAL + "'%s'" + Condition.AND + ColumnName.DATE + Condition.LESS_EQUAL + "'%s'" + Condition.SORT + ColumnName.DATE + Condition.DESC + Condition.LIMIT + "%s";
        querySql = String.format(querySql, TableName.CK_SZ_DAILY_ALL, assetId, date, limit);
        System.out.println("输出执行SQL：" + querySql);
        List<StkDaySz> result = clickHouseService.selectList(StkDaySz.class , querySql);
        result.forEach(info -> System.out.println("输出对象信息：" + JSONObject.toJSONString(info)));
    }

    /**
     * 批量插入测试
     */
    @Test
    public void batchInsert(){
        String tableName = "dw_all.quote_hk_daily_all";
        List<Object> list = new ArrayList<>();
        StkDayHk stkDayHk = new StkDayHk();
        stkDayHk.setAssetId("00700.HK");
        stkDayHk.setDate("2019-05-31");
        stkDayHk.setHigh(180.41);
        stkDayHk.setOpen(179.21);
        stkDayHk.setLow(189.52);
        stkDayHk.setClose(178.54);
        stkDayHk.setPreClose(181.47);
        stkDayHk.setVolume(8451.41);
        stkDayHk.setTurnover(953.89);
        stkDayHk.setTurnRate(88.31);
        stkDayHk.setkVal(1.2144477414);
        stkDayHk.setdVal(2.4587412635);
        stkDayHk.setjVal(3.9852147561);
        stkDayHk.setkVal_b(4.2144477414);
        stkDayHk.setdVal_b(8.4587412635);
        stkDayHk.setjVal_b(6.9852147561);
        stkDayHk.setkVal_f(2.2144477414);
        stkDayHk.setdVal_f(3.4587412635);
        stkDayHk.setjVal_f(1.9852147561);
        stkDayHk.setRsi1(10.545621245);
        stkDayHk.setRsi2(12.545621245);
        stkDayHk.setRsi3(11.545621245);
        stkDayHk.setRsi1_f(10.545621245);
        stkDayHk.setRsi2_f(12.545621245);
        stkDayHk.setRsi3_f(11.545621245);
        stkDayHk.setRsi1_b(10.545621245);
        stkDayHk.setRsi2_b(12.545621245);
        stkDayHk.setRsi3_b(11.545621245);
        stkDayHk.setAdjFactor(1.456);
        for (int i = 0; i < 1000; i++){
            StkDayHk info = new StkDayHk();
            BeanUtils.copyProperties(stkDayHk, info);
            list.add(info);
        }
//        list.add(stkWeekSz);
        clickHouseService.batchInsert(list, tableName);
        System.out.println("测试批量插入数据完成......");
    }

    /**
     * 删除测试
     */
    @Test
    public void deleteTest(){
        String tableName = TableName.CK_SZ_DAILY;
        String assetId = "zhanglei.SZ";
        String deleteSql = Condition.ALTER_TABLE + tableName + Condition.CK_CLUSTER_NAME + Condition.DELETE + Condition.WHERE + " asset_id = '%s'";
        deleteSql = String.format(deleteSql, assetId);
        System.out.println("打印执行SQL：" + deleteSql);
        clickHouseService.executeBySql(deleteSql);
        System.out.println("测试删除数据完成.....");
    }

    /**
     * 复权参数查询测试
     */
    @Test
    public void AdjFactorTest(){
        String adjFactorTable = "ods.jydb__QT_AdjustingFactor_tmp";
        String secumainTable = "ods_all.jydb__SecuMain_all";
        String assetId = "000001.SH";
        String date = "2019-05-20";
        String queryAdjFactorSqlTemplate = "select af.AdjustingFactor,af.AdjustingConst from (select * from %s ) af join (select InnerCode from %s where SecuCode = '%s' and SecuCategory = 1) sm on af.InnerCode = sm.InnerCode where af.ExDiviDate <= '%s' order by af.ExDiviDate desc limit 1";
        String queryAdjFactorSql =  String.format(queryAdjFactorSqlTemplate, adjFactorTable, secumainTable, assetId.split("\\.")[0], date + " 00:00:00");
        AdjFactor adjFactor = (AdjFactor)clickHouseService.selectInfo(AdjFactor.class, queryAdjFactorSql);
        System.out.println("输出复权数据信息：" + JSONObject.toJSONString(adjFactor));
    }

    /**
     * 最高最低查询测试
     */
    @Test
    public void highAndLow(){
        String querySql = "select asset_id, max(high) max_high, min(low) min_low from dw_all.quote_sz_weekly_all where date >= '2018-01-01' group by asset_id";
        List<HighAndLow> list = clickHouseService.selectList(HighAndLow.class, querySql);
        if(null != list && list.size() > 0){
            list.forEach(info -> System.out.println(JSONObject.toJSONString(info)));
        }
    }

    /**
     * 成交量及总比数查询测试
     */
    @Test
    public void volumeAndCount(){
        String querySql = "select asset_id, sum(volume) volume, count(*) as count from dw_all.quote_sz_weekly_all where date >= '2018-01-01' group by asset_id";
        List<VolumeAndCount> list = clickHouseService.selectList(VolumeAndCount.class, querySql);
        if(null != list && list.size() > 0){
            list.forEach(info -> System.out.println(JSONObject.toJSONString(info)));
        }
    }

    /**
     *  资讯新闻数据查询
     */
    @Test
    public void newsQueryTest(){
        String sql = "select * from ods.mktinfo__sp_label_news where is_important = 1 and (img_url is not null or img_url != '') and is_status = 1 order by issue_time desc";
        List<SpLabelNews> list = clickHouseService.selectList(SpLabelNews.class, sql);
        System.out.println("输出新闻资讯信息size：" + list.size());
//        if(null != list && list.size() > 0){
//            list.forEach(info -> System.out.println("输出新闻资讯信息：" + JSONObject.toJSONString(info)));
//        }
        String sqlCount = "select count(1) as count from ods.`mktinfo__sp_label_news`";
        NewsCount newsInfo = (NewsCount)clickHouseService.selectInfo(NewsCount.class, sqlCount);
        System.out.println("新闻资讯信息输出：" + newsInfo.getCount());
    }

    /**
     * 新闻更新条数查询
     */
    @Test
    public void newsCountTest(){
        String sql = "select count(1) as count from ods.`mktinfo__sp_label_news`";
        NewsCount newsInfo = (NewsCount)clickHouseService.selectInfo(NewsCount.class, sql);
        System.out.println("新闻资讯信息输出：" + newsInfo.getCount());
    }

    /**
     * 查询新闻最大ID
     */
    @Test
    public void queryMaxId(){
        String sql = "select max(label_news_id) as label_news_id from ods.`mktinfo__sp_label_news`";
        SpLabelNews newsInfo = (SpLabelNews)clickHouseService.selectInfo(SpLabelNews.class, sql);
        System.out.println("新闻资讯信息输出：" + newsInfo.getLabelNewsId());
    }


    @Test
    public void selectOne() {
        String sql = "SELECT * FROM ods.kamluen__user_operate_menu_log ORDER BY id DESC LIMIT 0,1";
        UserOperateLog operateLog = (UserOperateLog) clickHouseService.selectInfo(UserOperateLog.class, sql);
        System.out.println("输出日志信息: " + JSONObject.toJSONString(operateLog));
    }
}
