package com.kamluen.clickhouse.api.entity;

import com.kamluen.clickhouse.api.base.StkBaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 港股日K实体信息表
 */
@Entity
@Data
public class StkDayHk extends StkBaseEntity {

    @Column(name = "adj_factor")
    private Double adjFactor;

}