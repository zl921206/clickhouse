package com.kamluen.clickhouse.api.entity.kamluen;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package: com.kamluen.clickhouse.api.entity.kamluen
 * @Author: yyq
 * @Date: 2019/6/19
 * @Description:
 */
@Data
@Entity
public class TreasureEarningsDay implements Serializable {

    @Column(name = "user_id")
    private Integer userId;//羊羊id
    @Column(name = "total_today_earnings")
    private BigDecimal totalTodayEarnings;//总盈亏
    @Column(name = "total_amount")
    private BigDecimal totalAmount;//总市场金额
    @Column(name = "today_earnings_rate")
    private BigDecimal todayEarningsRate;//总收益率
    @Column(name = "earnings_date")
    private String earningsDate;//收益率日期
    @Column(name = "today_security_earnings")
    private BigDecimal todaySecurityEarnings;//今日证券收益
    @Column(name = "total_security_amount")
    private BigDecimal totalSecurityAmount;//总证券金额
    @Column(name = "security_earnings_rate")
    private BigDecimal securityEarningsRate;//证券收益率
    @Column(name = "today_foreign_exchange_earnings")
    private BigDecimal todayForeignExchangeEarnings;//今日外汇收益
    @Column(name = "total_foreign_exchange")
    private BigDecimal totalForeignExchange;//外汇总和
    @Column(name = "foreign_exchange_rate")
    private BigDecimal foreignExchangeRate;//外汇收益率
    @Column(name = "today_wool_earnings")
    private BigDecimal todayWoolEarnings;//今日羊毛收益
    @Column(name = "total_wool")
    private BigDecimal totalWool;//总羊毛数
    @Column(name = "wool_rate")
    private BigDecimal woolRate;//羊毛收益率
    @Column(name = "today_insurance_earnings")
    private BigDecimal todayInsuranceEarnings;//今日保险收益
    @Column(name = "total_insurance_amount")
    private BigDecimal totalInsuranceAmount;//总保险金额
    @Column(name = "insurance_rate")
    private BigDecimal insuranceRate;//保险收益率
    @Column(name = "today_credit_loan_earnings")
    private BigDecimal todayCreditLoanEarnings;//今日信贷收益
    @Column(name = "total_credit_loan")
    private BigDecimal totalCreditLoan;//总信贷金额
    @Column(name = "credit_loan_rate")
    private BigDecimal creditLoanRate;//信贷收益率
    @Column(name = "today_profit_loss")
    private BigDecimal todayProfitLoss;//今日盈亏
    @Column(name = "total_profit_loss")
    private BigDecimal totalProfitLoss;//累计盈亏
    @Column(name = "profit_loss_proportion")
    private BigDecimal profitLossProportion;//盈亏比例
    @Column(name = "stock_profit_loss")
    private BigDecimal stockProfitLoss;//股票盈亏
    @Column(name = "stock_profit_loss_proportion")
    private BigDecimal stockProfitLossProportion;//股票盈亏比例
    @Column(name = "stock_profit_loss_hk")
    private BigDecimal stockProfitLossHk;//港股
    @Column(name = "stock_profit_loss_us")
    private BigDecimal stockProfitLossUs;//美股
    @Column(name = "stock_profit_loss_cny")
    private BigDecimal stockProfitLossCny;//中华通
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "create_name")
    private String createName;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "update_name")
    private String updateName;
}
