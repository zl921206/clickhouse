package com.kamluen.clickhouse.api.base;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * 此公共实体仅定义历史K线属性
 */
@Entity
@Data
public class StkBaseEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8114469813921890858L;
	// 公共属性
    @Column(name = "asset_id")
    public String assetId;//资产ID
    @Column(name = "date")
    public String date;//日期

    // 不复权属性
    @Column(name = "open")
    public Double open;//开盘价
    @Column(name = "high")
    public Double high;//最高价
    @Column(name = "low")
    public Double low;//最低价
    @Column(name = "close")
    public Double close;//收盘价
    @Column(name = "pre_close")
    public Double preClose;//前收盘价
    @Column(name = "volume")
    public Double volume;//成交量
    @Column(name = "turnover")
    public Double turnover;//成交额
    @Column(name = "turn_rate")
    public Double turnRate;//换手率

    @Column(name = "k")
    public Double kVal = 100.0000d;//不复权K值
    @Column(name = "d")
    public Double dVal = 100.0000d;//不复权D值
    @Column(name = "j")
    public Double jVal = 100.0000d;//不复权J值

    @Column(name = "ema1")
    public Double ema1 = 0.0000d;//快速平滑移动平均线
    @Column(name = "ema2")
    public Double ema2 = 0.0000d;//慢速平滑移动平均线
    @Column(name = "dea")
    public Double dea = 0.0000d;//异同平均数

    @Column(name = "rsi1")
    public Double rsi1 = 0.0d;	// 相对强弱指数
    @Column(name = "rsi2")
    public Double rsi2 = 0.0d;	// 相对强弱指数
    @Column(name = "rsi3")
    public Double rsi3 = 0.0d;	// 相对强弱指数
    @Column(name = "sma_u1")
    public Double upSeq1 = 0.0000d;//6日涨序列值
    @Column(name = "sma_d1")
    public Double downSeq1 = 0.0000d;//6日跌序列值
    @Column(name = "sma_u2")
    public Double upSeq2 = 0.0000d;//12日涨序列值
    @Column(name = "sma_d2")
    public Double downSeq2 = 0.0000d;//12日跌序列值
    @Column(name = "sma_u3")
    public Double upSeq3 = 0.0000d;//24日涨序列值
    @Column(name = "sma_d3")
    public Double downSeq3 = 0.0000d;//24日跌序列值

    // 后复权属性
    @Column(name = "open_b")
    public Double open_b;//开盘价
    @Column(name = "high_b")
    public Double high_b;//最高价
    @Column(name = "low_b")
    public Double low_b;//最低价
    @Column(name = "close_b")
    public Double close_b;//收盘价
    @Column(name = "pre_close_b")
    public Double preClose_b;//前收盘价
//    @Column(name = "volume_b")
//    public Double volume_b;//成交量
//    @Column(name = "turnover_b")
//    public Double turnover_b;//成交额
//    @Column(name = "turn_rate_b")
//    public Double turnRate_b;//换手率

    @Column(name = "k_b")
    public Double kVal_b = 100.0000d;//不复权K值
    @Column(name = "d_b")
    public Double dVal_b = 100.0000d;//不复权D值
    @Column(name = "j_b")
    public Double jVal_b = 100.0000d;//不复权J值

    @Column(name = "ema1_b")
    public Double ema1_b = 0.0000d;//快速平滑移动平均线
    @Column(name = "ema2_b")
    public Double ema2_b = 0.0000d;//慢速平滑移动平均线
    @Column(name = "dea_b")
    public Double dea_b = 0.0000d;//异同平均数

    @Column(name = "rsi1_b")
    public Double rsi1_b = 0.0d;	// 相对强弱指数
    @Column(name = "rsi2_b")
    public Double rsi2_b = 0.0d;	// 相对强弱指数
    @Column(name = "rsi3_b")
    public Double rsi3_b = 0.0d;	// 相对强弱指数
    @Column(name = "sma_u1_b")
    public Double upSeq1_b = 0.0000d;//6日涨序列值
    @Column(name = "sma_d1_b")
    public Double downSeq1_b = 0.0000d;//6日跌序列值
    @Column(name = "sma_u2_b")
    public Double upSeq2_b = 0.0000d;//12日涨序列值
    @Column(name = "sma_d2_b")
    public Double downSeq2_b = 0.0000d;//12日跌序列值
    @Column(name = "sma_u3_b")
    public Double upSeq3_b = 0.0000d;//24日涨序列值
    @Column(name = "sma_d3_b")
    public Double downSeq3_b = 0.0000d;//24日跌序列值

    // 前复权属性
    @Column(name = "open_f")
    public Double open_f;//开盘价
    @Column(name = "high_f")
    public Double high_f;//最高价
    @Column(name = "low_f")
    public Double low_f;//最低价
    @Column(name = "close_f")
    public Double close_f;//收盘价
    @Column(name = "pre_close_f")
    public Double preClose_f;//前收盘价
//    @Column(name = "volume_f")
//    public Double volume_f;//成交量
//    @Column(name = "turnover_f")
//    public Double turnover_f;//成交额
//    @Column(name = "turn_rate_f")
//    public Double turnRate_f;//换手率

    @Column(name = "k_f")
    public Double kVal_f = 100.0000d;//不复权K值
    @Column(name = "d_f")
    public Double dVal_f = 100.0000d;//不复权D值
    @Column(name = "j_f")
    public Double jVal_f = 100.0000d;//不复权J值

    @Column(name = "ema1_f")
    public Double ema1_f = 0.0000d;//快速平滑移动平均线
    @Column(name = "ema2_f")
    public Double ema2_f = 0.0000d;//慢速平滑移动平均线
    @Column(name = "dea_f")
    public Double dea_f = 0.0000d;//异同平均数

    @Column(name = "rsi1_f")
    public Double rsi1_f = 0.0d;	// 相对强弱指数
    @Column(name = "rsi2_f")
    public Double rsi2_f = 0.0d;	// 相对强弱指数
    @Column(name = "rsi3_f")
    public Double rsi3_f = 0.0d;	// 相对强弱指数
    @Column(name = "sma_u1_f")
    public Double upSeq1_f = 0.0000d;//6日涨序列值
    @Column(name = "sma_d1_f")
    public Double downSeq1_f = 0.0000d;//6日跌序列值
    @Column(name = "sma_u2_f")
    public Double upSeq2_f = 0.0000d;//12日涨序列值
    @Column(name = "sma_d2_f")
    public Double downSeq2_f = 0.0000d;//12日跌序列值
    @Column(name = "sma_u3_f")
    public Double upSeq3_f = 0.0000d;//24日涨序列值
    @Column(name = "sma_d3_f")
    public Double downSeq3_f = 0.0000d;//24日跌序列值

    public Double getkVal() {
        return kVal;
    }

    public void setkVal(Double kVal) {
        this.kVal = kVal;
    }

    public Double getdVal() {
        return dVal;
    }

    public void setdVal(Double dVal) {
        this.dVal = dVal;
    }

    public Double getjVal() {
        return jVal;
    }

    public void setjVal(Double jVal) {
        this.jVal = jVal;
    }

    public Double getkVal_b() {
        return kVal_b;
    }

    public void setkVal_b(Double kVal_b) {
        this.kVal_b = kVal_b;
    }

    public Double getdVal_b() {
        return dVal_b;
    }

    public void setdVal_b(Double dVal_b) {
        this.dVal_b = dVal_b;
    }

    public Double getjVal_b() {
        return jVal_b;
    }

    public void setjVal_b(Double jVal_b) {
        this.jVal_b = jVal_b;
    }

    public Double getkVal_f() {
        return kVal_f;
    }

    public void setkVal_f(Double kVal_f) {
        this.kVal_f = kVal_f;
    }

    public Double getdVal_f() {
        return dVal_f;
    }

    public void setdVal_f(Double dVal_f) {
        this.dVal_f = dVal_f;
    }

    public Double getjVal_f() {
        return jVal_f;
    }

    public void setjVal_f(Double jVal_f) {
        this.jVal_f = jVal_f;
    }
}
