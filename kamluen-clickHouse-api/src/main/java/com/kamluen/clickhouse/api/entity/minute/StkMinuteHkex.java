package com.kamluen.clickhouse.api.entity.minute;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;


import lombok.Data;

@Entity
@Data
/**
 * 港股分钟K线实体对象
 * @ClassName:  StkMinuteHkex1   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: wangjia 
 * @date:   2019年5月6日 下午2:24:46   
 *     
 * @Copyright: 2019 www.kamluen.com 
 * 注意：本内容仅限于深圳金銮网络技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class StkMinuteHkex implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3618032953200427988L;
	@Column(name = "asset_id")
    public String assetId;//资产ID
    @Column(name = "time")
    public Date time;//日期
    @Column(name = "stk_code")
    public String stkCode;//资产ID
    @Column(name = "open")
    public Double open;//开盘价
    @Column(name = "high")
    public Double high;//最高价
    @Column(name = "low")
    public Double low;//最低价
    @Column(name = "close")
    public Double close;//收盘价
    @Column(name = "prev_close")
    public Double prevClose;//前收盘价
    @Column(name = "volume")
    public Double volume;//成交量
    @Column(name = "turnover")
    public Double turnover;//成交额
    @Column(name = "turn_rate")
    public Double turnRate;//换手率
    @Column(name = "adj_factor")
    public Double adjFactor = 1.00000000d;//复权调整因子

    @Column(name = "k_val")
    public Double kVal = 100.0000d;//不复权K值
    @Column(name = "d_val")
    public Double dVal = 100.0000d;//不复权D值
    @Column(name = "j_val")
    public Double jVal = 100.0000d;//不复权J值
    
    @Column(name = "k_val_adj")
    public Double kValAdj = 100.0d;//复权K值
    @Column(name = "d_val_adj")
    public Double dValAdj = 100.0d;//复权D值
    @Column(name = "j_val_adj")
    public Double jValAdj = 100.0d;//复权J值

    @Column(name = "ema1")
    public Double ema1 = 0.0000d;//快速平滑移动平均线
    @Column(name = "ema2")
    public Double ema2 = 0.0000d;//慢速平滑移动平均线
    @Column(name = "dea")
    public Double dea = 0.0000d;//异同平均数

    @Column(name = "ema1_bkw")
    public Double ema1Bkw = 0.0000d;//快速平滑移动平均线（后复权），前复权值可通过最新的复权因子计算
    @Column(name = "ema2_bkw")
    public Double ema2Bkw = 0.0000d;//慢速平滑移动平均线（后复权），前复权值可通过最新的复权因子计算
    @Column(name = "dea_bkw")
    public Double deaBkw = 0.0000d;//异同平均数（后复权），前复权值可通过最新的复权因子计算
    
    @Column(name = "up_seq1")
    public Double up_seq1 = 0.0000d;//6日涨序列值
    @Column(name = "down_seq1")
    public Double downSeq1 = 0.0000d;//6日跌序列值
    @Column(name = "up_seq2")
    public Double upSeq2 = 0.0000d;//12日涨序列值
    @Column(name = "down_seq2")
    public Double downSeq2 = 0.0000d;//12日跌序列值
    @Column(name = "up_seq3")
    public Double upSeq3 = 0.0000d;//24日涨序列值
    @Column(name = "down_seq3")
    public Double downSeq3 = 0.0000d;//24日跌序列值
    
    
    @Column(name = "up_seq1_bkw")
    public Double upSeq1Bkw = 0.0000d;//6日涨序列值（后复权），前复权值可通过最新的复权因子计算
    @Column(name = "down_seq1_bkw")
    public Double downSeq1Bkw = 0.0000d;//6日跌序列值（后复权），前复权值可通过最新的复权因子计算
    @Column(name = "up_seq2_bkw")
    public Double upSeq2Bkw = 0.0000d;//12日涨序列值（后复权），前复权值可通过最新的复权因子计算
    @Column(name = "down_seq2_bkw")
    public Double downSeq2Bkw = 0.0000d;//12日跌序列值（后复权），前复权值可通过最新的复权因子计算
    @Column(name = "up_seq3_bkw")
    public Double upSeq3Bkw = 0.0000d;//24日涨序列值（后复权），前复权值可通过最新的复权因子计算
    @Column(name = "down_seq3_bkw")
    public Double downSeq3Bkw = 0.0000d;//24日跌序列值（后复权），前复权值可通过最新的复权因子计算
    @Column(name = "status")
    public Integer status;//状态
}
