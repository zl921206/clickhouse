package com.kamluen.clickhouse.api.entity.news;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 *  clickhouse新闻表实体类
 */
@Data
@Entity
public class SpLabelNews implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;

    /**
     * 标签新闻ID
     */
    @Column(name = "label_news_id")
	private Integer labelNewsId;
    /**
     *  原新闻发布时间
     */
    @Column(name = "issue_time")
	private Date issueTime;
    /**
     *  新闻标题
     */
    @Column(name = "title")
	private String title;
    /**
     *  资讯文本html
     */
    @Column(name = "content")
	private String content;
    /**
     *  资讯来源url
     */
    @Column(name = "url")
	private String url;
    /**
     *  是否有效
     */
    @Column(name = "is_status")
	private Integer isStatus = 1;
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
    /**
     *  是否确认
     */
    @Column(name = "is_confirm")
	private Integer isConfirm = 0;
    /**
     *  是否修改
     */
    @Column(name = "is_revise")
	private Integer isRevise = 0;
    /**
     *  是否要闻
     */
    @Column(name = "is_important")
	private Integer isImportant = 0;
    /**
     *  新闻标签
     */
    @Column(name = "tag")
	private Integer tag;
    /**
     *  是否直播
     */
    @Column(name = "is_live")
	private Integer isLive = 0;
    /**
     *  存储资讯关联股票，用于全文索引搜索自选股资讯
     */
    @Column(name = "gp")
	private String gp;
    /**
     *  存储资讯关联股票名称，用于全文索引搜索自选股资讯
     */
    @Column(name = "stk_name")
	private String stkName;
    /**
     *  栏目ID
     */
    @Column(name = "infotreeid")
	private Integer infotreeid;
    /**
     *  新闻图片url
     */
    @Column(name = "img_url")
	private String imgUrl;
    /**
     *  纯文本内容
     */
    @Column(name = "content_text")
	private String contentText;
    /**
     *  摘要
     */
    @Column(name = "summary")
	private String summary;

}