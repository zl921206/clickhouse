package com.kamluen.clickhouse.api.entity.tradeticker;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
@Entity
@Data
public class TradeStatisticsEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3782089851943648466L;
	@Column(name = "price")
	private Double price;//平均成交价
	@Column(name = "totalCount")
	private Integer totalCount;//总交易笔数
	@Column(name = "totalVol")
	private Long totalVol;//总交易量
	@Column(name = "buyVol")
	private Long buyVol;//主动买入量
	@Column(name = "sellVol")
	private Long sellVol;//主动卖出量
	@Column(name = "midVol")
	private Long midVol;//中性盘
	@Column(name = "rate")
	private Double rate;//占比
}
