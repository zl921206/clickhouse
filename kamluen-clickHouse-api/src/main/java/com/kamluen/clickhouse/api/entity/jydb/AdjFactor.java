package com.kamluen.clickhouse.api.entity.jydb;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 定义A股聚源数据-复权因子表实体
 */
@Entity
@Data
public class AdjFactor implements Serializable {

    @Column(name = "ID")
    public Long id;
    @Column(name = "ExDiviDate")
    public Date exDiviDate;
    @Column(name = "InnerCode")
    public Integer innerCode;
    @Column(name = "AdjustingFactor")
    public Double adjustingFactor;
    @Column(name = "AdjustingConst")
    public Double adjustingConst;
    @Column(name = "RatioAdjustingFactor")
    public Double ratioAdjustingFactor;
    @Column(name = "AccuCashDivi")
    public Double accuCashDivi;
    @Column(name = "AccuBonusShareRatio")
    public Double accuBonusShareRatio;
    @Column(name = "XGRQ")
    public Date updateTime;
    @Column(name = "JSID")
    public Long jsId;

}
