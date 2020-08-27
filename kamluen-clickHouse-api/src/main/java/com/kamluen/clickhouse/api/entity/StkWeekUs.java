package com.kamluen.clickhouse.api.entity;

import com.kamluen.clickhouse.api.base.StkBaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 美股周K实体信息表
 */
@Data
@Entity
public class StkWeekUs extends StkBaseEntity {

    @Column(name = "week_id")
    public Integer weekId;  // 周ID

}