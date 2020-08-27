package com.kamluen.clickhouse.api.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * 最高最低统计实体类
 */
@Data
@Entity
public class HighAndLow  implements Serializable {

    /**
     *  股票代码
     */
    @Column(name = "asset_id")
    private String assetId;
    /**
     *  最高价
     */
    @Column(name = "max_high")
    private Double maxHigh;
    /**
     *  最低价
     */
    @Column(name = "min_low")
    private Double minLow;
}
