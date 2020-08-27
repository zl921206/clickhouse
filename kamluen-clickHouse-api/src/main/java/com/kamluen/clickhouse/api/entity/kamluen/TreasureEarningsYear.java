package com.kamluen.clickhouse.api.entity.kamluen;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 财富年分析数据
 * yuyaqiu 2019-06-20
 */
@Data
@Entity
public class TreasureEarningsYear implements Serializable {
    @Column(name = "user_id")
    private String userId;
    @Column(name = "year_total_earnings")
    private BigDecimal yearTotalEarnings;
    @Column(name = "year_total_amount")
    private BigDecimal yearTotalAmount;
    @Column(name = "year_earnings_rate")
    private BigDecimal yearEarningsRate;
    @Column(name = "earnings_date_year")
    private String earningsDateYear;
    @Column(name = "year_security_earnings")
    private BigDecimal yearSecurityEarnings;
    @Column(name = "year_total_security_amount")
    private BigDecimal yearTotalSecurityAmount;
    @Column(name = "year_security_earnings_rate")
    private BigDecimal yearSecurityEarningsRate;
    @Column(name = "year_foreign_exchange_earnings")
    private BigDecimal yearForeignExchangeEarnings;
    @Column(name = "year_total_foreign_exchange")
    private BigDecimal yearTotalForeignExchange;
    @Column(name = "year_foreign_exchange_rate")
    private BigDecimal yearForeignExchangeRate;
    @Column(name = "year_wool_earnings")
    private BigDecimal yearWoolEarnings;
    @Column(name = "year_total_wool")
    private BigDecimal yearTotalWool;
    @Column(name = "year_wool_rate")
    private BigDecimal yearWoolRate;
    @Column(name = "year_insurance_earnings")
    private BigDecimal yearInsuranceEarnings;
    @Column(name = "year_total_insurance_amount")
    private BigDecimal yearTotalInsuranceAmount;
    @Column(name = "year_insurance_rate")
    private BigDecimal yearInsuranceRate;
    @Column(name = "year_credit_loan_earnings")
    private BigDecimal yearCreditLoanEarnings;
    @Column(name = "year_total_credit_loan")
    private BigDecimal yearTotalCreditLoan;
    @Column(name = "year_credit_loan_rate")
    private BigDecimal yearCreditLoanRate;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "create_name")
    private String createName;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "update_name")
    private String updateName;
}
