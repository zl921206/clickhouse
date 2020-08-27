package com.kamluen.clickhouse.api.entity.tradeticker;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;


import lombok.Data;
@Entity
@Data
/**
 * 分笔成交对象
 * @ClassName:  TradeTicker   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: wangjia 
 * @date:   2019年5月8日 下午4:19:00   
 *     
 * @Copyright: 2019 www.kamluen.com 
 * 注意：本内容仅限于深圳金銮网络技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class TradeTickerEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9172207646136004553L;
	@Column(name = "asset_id")
	public String assetId;
	@Column(name = "trade_date")
	public Date tradeDate;
	@Column(name = "price")
	public Double price; // 价格，3位小数
	@Column(name = "qty")
	public Long qty = 0L; // 数量
	@Column(name = "up")
	public Integer up; // 涨=true，跌=false
	@Column(name = "type")
	public Integer type;
	@Column(name = "trade_time")
	public Date tradeTime;
}
