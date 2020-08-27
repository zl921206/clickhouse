package com.kamluen.clickhouse.api.entity.kamluen;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 财富月分析表
 * yuyaqiu 2019-06-20
 */
@Data
@Entity
public class TreasureEarningsMonth implements Serializable {

    @Column(name = "user_id")
    private String userId;
    @Column(name = "month_total_earnings")
    private BigDecimal monthTotalEarnings;
    @Column(name = "month_total_amount")
    private BigDecimal monthTotalAmount;
    @Column(name = "month_earnings_rate")
    private BigDecimal monthEarningsRate;
    @Column(name = "earnings_date_year")
    private String earningsDateYear;
    @Column(name = "earnings_date_month")
    private String earningsDateMonth;
    @Column(name = "month_security_earnings")
    private BigDecimal monthSecurityEarnings;
    @Column(name = "month_total_security_amount")
    private BigDecimal monthTotalSecurityAmount;
    @Column(name = "month_security_earnings_rate")
    private BigDecimal monthSecurityEarningsRate;
    @Column(name = "month_foreign_exchange_earnings")
    private BigDecimal monthForeignExchangeEarnings;
    @Column(name = "month_total_foreign_exchange")
    private BigDecimal monthTotalForeignExchange;
    @Column(name = "month_foreign_exchange_rate")
    private BigDecimal monthForeignExchangeRate;
    @Column(name = "month_wool_earnings")
    private BigDecimal monthWoolEarnings;
    @Column(name = "month_total_wool")
    private BigDecimal monthTotalWool;
    @Column(name = "month_wool_rate")
    private BigDecimal monthWoolRate;
    @Column(name = "month_insurance_earnings")
    private BigDecimal monthInsuranceEarnings;
    @Column(name = "month_total_insurance_amount")
    private BigDecimal monthTotalInsuranceAmount;
    @Column(name = "month_insurance_rate")
    private BigDecimal monthInsuranceRate;
    @Column(name = "month_credit_loan_earnings")
    private BigDecimal monthCreditLoanEarnings;
    @Column(name = "month_total_credit_loan")
    private BigDecimal monthTotalCreditLoan;
    @Column(name = "month_credit_loan_rate")
    private BigDecimal monthCreditLoanRate;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "create_name")
    private String createName;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "update_name")
    private String updateName;
}
