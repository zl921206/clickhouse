package com.kamluen.clickhouse.api.entity.blockChain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 *  clickhouse区块链存证实体类
 */
@Data
@Entity
public class ReqRecordEntity implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;

    /**
     * 主键id
     */
    @Column(name = "id")
	private Integer id;
    /**
     *  用户id
     */
    @Column(name = "user_id")
	private Integer userId;
    /**
     *  用户姓名
     */
    @Column(name = "user_name")
	private String userName;
    /**
     * 用户头像
     */
    @Column(name = "user_icon")
	private String userIcon;
    /**
     *  客户id
     */
    @Column(name = "client_id")
	private Integer clientId;
    /**
     * 客户地址
     */
    @Column(name = "client_address")
	private String  clientAddress ;
    
    /**
     *  摘要
     */
    @Column(name = "request_model")
	private String requestModel;
    
    /**
     *  客户id
     */
    @Column(name = "submit_status")
	private Integer submitStatus;
    
    /**
     *  创建时间
     */
    @Column(name = "create_time")
	private Date createTime;
    /**
     *  修改时间
     */
    @Column(name = "update_time")
	private Date updateTime;


    
    

    

}