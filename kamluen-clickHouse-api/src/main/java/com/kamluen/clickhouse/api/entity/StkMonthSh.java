package com.kamluen.clickhouse.api.entity;

import com.kamluen.clickhouse.api.base.StkBaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * A股sh月K实体信息表
 */
@Data
@Entity
public class StkMonthSh extends StkBaseEntity {

    @Column(name = "month_id")
    public Integer monthId; // 月ID

}