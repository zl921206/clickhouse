package com.kamluen.clickhouse.api.entity.minute;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class StkTimesharing implements Serializable {
	private static final long serialVersionUID = -3618032953200427988L;
	@Column(name = "asset_id")
    public String assetId;//资产ID
    @Column(name = "time")
    public String time;//时间
    @Column(name = "ts_id")
    public Long tsId;
    @Column(name = "price")
    public String price;
    @Column(name = "avg_price")
    public String avgPrice;//最高价
    @Column(name = "volume")
    public String volume;//最低价
    @Column(name = "date")
    public Date date;//日期
}
