package com.kamluen.clickhouse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kamluen.clickhouse.api.constant.TableName;
import com.kamluen.clickhouse.api.entity.StkDayHk;
import com.kamluen.clickhouse.api.entity.blockChain.ReqRecordEntity;
import com.kamluen.clickhouse.api.service.ClickHouseService;
import com.kamluen.clickhouse.core.ClickHouseApplication;
import com.kamluen.clickhouse.core.handler.ClickHouseHandler;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClickHouseApplication.class)
public class BlockChainTest {

    @Resource
    private ClickHouseService clickHouseService;

    @Resource
    ClickHouseHandler clickHouseHandler;
	
	@Test
	public void batchInsertBlockChain(){

        String tableName = "ods_all.block_chain__req_record_all";
        List<Object> list = new ArrayList<>();
        ReqRecordEntity entity = new ReqRecordEntity();
        entity.setClientAddress("22222222dffffffgg");
        entity.setClientId(6001256);
        entity.setCreateTime(new Date());
        entity.setId(15056);
        entity.setRequestModel("羊毛值存证");
        entity.setUpdateTime(new Date());
        entity.setUserIcon("/APP/UPLOAD/HEAD_PICTURE/2019/03/15/087551bc2faf462e8724ee656a1260d3_640x640.png");
        entity.setUserId(100516);
        entity.setUserName("李柱新");
        list.add(entity);
        clickHouseService.batchInsert(list, tableName);
        System.out.println("测试批量插入数据完成......");
	 
		
	}
	@SuppressWarnings("all")
	@Test
	public void queryBlockChain(){

//		String date = "2019-05-31";
//        String groupSql = "select * from "+TableName.CK_BLOCK_CHAIN_ALL+" hk  order by hk.update_time desc  limit %s,%s";      
//        groupSql = String.format(groupSql, 1, 10);
//        List<ReqRecordEntity> result = clickHouseService.selectList(ReqRecordEntity.class , groupSql);
//		
        
        StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(id) as num FROM "+TableName.CK_BLOCK_CHAIN_ALL);

//		Object[] params = {assetId, DateUtils.dateToString(date, "yyyy-MM-dd")};
	
		 Object selectInfo = clickHouseService.selectInfo(Integer.class, sql.toString());
		
		
        System.out.println("测试批量插入数据完成......"+Integer.valueOf(selectInfo+""));
	 
		
	}
	
	
}
