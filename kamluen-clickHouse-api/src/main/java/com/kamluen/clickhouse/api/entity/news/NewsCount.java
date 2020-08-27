package com.kamluen.clickhouse.api.entity.news;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 *  clickhouse新闻总数统计实体
 */
@Data
@Entity
public class NewsCount implements Serializable {

    /**
     *  更新条数
     */
    @Column(name = "count")
    private Integer count;
}
