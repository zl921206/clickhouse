package com.kamluen.clickhouse.api.entity.kamluen;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * @Package: com.kamluen.clickhouse.api.entity.kamluen
 * @Author: LQW
 * @Date: 2019/6/18
 * @Description:
 */
@Data
@Entity
public class UserOperateLog implements Serializable {

    @Column(name = "id")
    private Integer id;
    /**
     *  用户id
     */
    @Column(name = "user_id")
    private Integer userId;
    /**
     *  姓名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     *  手机号
     */
    @Column(name = "user_phone")
    private String userPhone;
    /**
     *  操作菜单
     */
    @Column(name = "operate_menu")
    private String operateMenu;
    /**
     *  菜单id
     */
    @Column(name = "menu_id")
    private Integer menuId;
    /**
     *   来源
     */
    @Column(name = "request_src")
    private String requestSrc;
    /**
     *  创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 图标url
     */
    @Column(name = "img_url")
    private String imgUrl;
}
