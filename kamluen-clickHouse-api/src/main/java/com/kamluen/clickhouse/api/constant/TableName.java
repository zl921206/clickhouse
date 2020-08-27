package com.kamluen.clickhouse.api.constant;

public class TableName {

    /**
     * --------------------------------------A股sz相关表-------------------------------------------
     */

    // 生产表（删除时使用）
    public static final String CK_SZ_DAILY = " dw.quote_sz_daily ";    //日K表

    public static final String CK_SZ_WEEKLY = " dw.quote_sz_weekly ";    // 周K表

    public static final String CK_SZ_MONTHLY = " dw.quote_sz_monthly ";    // 月K表

    // 分布式生产表，用于查询，插入
    public static final String CK_SZ_DAILY_ALL = " dw_all.quote_sz_daily_all ";    //日K分布式表

    public static final String CK_SZ_WEEKLY_ALL = " dw_all.quote_sz_weekly_all ";    //周K分布式表

    public static final String CK_SZ_MONTHLY_ALL = " dw_all.quote_sz_monthly_all ";//月K分布式表


    /**
     * --------------------------------------A股sh相关表-------------------------------------------
     */

    // 生产表（删除时使用）
    public static final String CK_SH_DAILY = " dw.quote_sh_daily ";    //日K表

    public static final String CK_SH_WEEKLY = " dw.quote_sh_weekly ";    // 周K表

    public static final String CK_SH_MONTHLY = " dw.quote_sh_monthly ";    // 月K表

    // 分布式生产表，用于查询，插入
    public static final String CK_SH_DAILY_ALL = " dw_all.quote_sh_daily_all ";    //日K分布式表

    public static final String CK_SH_WEEKLY_ALL = " dw_all.quote_sh_weekly_all ";    //周K分布式表

    public static final String CK_SH_MONTHLY_ALL = " dw_all.quote_sh_monthly_all ";//月K分布式表

    /**
     * -----------------------------------------港股HK相关表---------------------------------------
     */

    // 生产表（删除时使用）
    public static final String CK_HK_DAILY = " dw.quote_hk_daily ";    //日K表

    public static final String CK_HK_WEEKLY = " dw.quote_hk_weekly ";    // 周K表

    public static final String CK_HK_MONTHLY = " dw.quote_hk_monthly ";    // 月K表

    // 分布式生产表，用于查询，插入
    public static final String CK_HK_DAILY_ALL = " dw_all.quote_hk_daily_all_view ";    //日K分布式表

    public static final String CK_HK_WEEKLY_ALL = " dw_all.quote_hk_weekly_all_view ";    //周K分布式表

    public static final String CK_HK_MONTHLY_ALL = " dw_all.quote_hk_monthly_all_view ";//月K分布式表


    /**
     * --------------------------------------美股US相关表-------------------------------------------
     */

    // 生产表（删除时使用）
    public static final String CK_US_DAILY = " dw.quote_us_daily ";    //日K表

    public static final String CK_US_WEEKLY = " dw.quote_us_weekly ";    // 周K表

    public static final String CK_US_MONTHLY = " dw.quote_us_monthly ";    // 月K表

    // 分布式生产表，用于查询，插入
    public static final String CK_US_DAILY_ALL = " dw_all.quote_us_daily_all_view ";    //日K分布式表

    public static final String CK_US_WEEKLY_ALL = " dw_all.quote_us_weekly_all_view ";    //周K分布式表

    public static final String CK_US_MONTHLY_ALL = " dw_all.quote_us_monthly_all_view ";    //月K分布式表




    /** --------------------------------- A股 - 聚源复权因子表 ----------------------------- start */
    public static final String CK_JY_A_ADJ_FACTOR_ALL = " ods_all.jydb__QT_AdjustingFactor_all ";
    /** --------------------------------- A股 - 聚源复权因子表 ----------------------------- end */


    /** --------------------------------- A股 - 聚源证券主表 ----------------------------- start */
    public static final String CK_JY_A_SECUMAIN_ALL = " ods_all.jydb__SecuMain_all ";
    /** --------------------------------- A股 - 聚源证券主表 ----------------------------- end */


    /** --------------------------------- 新闻资讯表 ----------------------------- start */
    public static final String CK_NEWS_ALL = " ods_all.mktinfo__sp_label_news_all ";
    public static final String CK_NEWS = " ods.mktinfo__sp_label_news ";
    /** --------------------------------- 新闻资讯表 ----------------------------- end */


    //区块链存证
    public static final String CK_BLOCK_CHAIN_ALL = " ods_all.block_chain__req_record_all ";

    public static final String CK_BLOCK_CHAIN = " ods_all.block_chain__req_record ";

    //财富分析日表
    public static final String EARNINGS_DAY=" ods.kamluen_t_treasure_earnings_d";

    //财富分析月表
    public static final String EARNINGS_MONTH=" ods.kamluen_t_treasure_earnings_m";

    //财富分析年表
    public static final String EARNINGS_YEAR=" ods.kamluen_t_treasure_earnings_y";
}