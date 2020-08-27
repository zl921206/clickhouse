package com.kamluen.clickhouse.api.entity.kamluen;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class TreasureEarningsDayCount  implements Serializable {
    @Column(name = "count")
    private Integer count;
}
