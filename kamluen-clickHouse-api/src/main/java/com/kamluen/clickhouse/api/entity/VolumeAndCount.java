package com.kamluen.clickhouse.api.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * 统计成交量及总比数实体类
 */
@Data
@Entity
public class VolumeAndCount implements Serializable {

    /**
     *  股票代码
     */
    @Column(name = "asset_id")
    private String assetId;
    /**
     *  成交量
     */
    @Column(name = "volume")
    private Double volume;
    /**
     *  总比数
     */
    @Column(name = "count")
    private Integer count;
}
