package com.kamluen.clickhouse.api.entity.kamluen;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * @Package: com.kamluen.clickhouse.api.entity.kamluen
 * @Author: LQW
 * @Date: 2019/6/20
 * @Description:
 */
@Data
@Entity
public class UserOperateImg implements Serializable {

    @Column(name = "id")
    private Integer id;
    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;
    /**
     * 菜单名称 - 繁体
     */
    @Column(name = "traditional")
    private String traditional;
    /**
     * 图片路径
     */
    @Column(name = "img_url")
    private String imgUrl;
    /**
     * 描述
     */
    @Column(name = "menu_desc")
    private String menuDesc;
    /**
     * 创建人
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private Integer createUserId;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
    /**
     * 是否启用
     */
    @Column(name = "status")
    private Integer status;
}
