package com.kamluen.clickhouse.api.constant;

/**
 * SQL查询拼接
 */
public class SqlJoin {

    /**
     * 日，周，月 公共字段查询拼接,包含前复权，后复权和不复权
     */
    public static final String FIND_QUOTE_BASE = "asset_id,date,open,high,low,close,pre_close,volume,turnover,turn_rate";
    public static final String FIND_QUOTE_KDJ = "k,d,j";
    public static final String FIND_QUOTE_MACD = "ema1,ema2,dea";
    public static final String FIND_QUOTE_RSI = "rsi1,rsi2,rsi3,sma_u1,sma_d1,sma_u2,sma_d2,sma_u3,sma_d3";

    public static final String FIND_QUOTE_BASE_B = "asset_id,date,open_b,high_b,low_b,close_b,pre_close_b,volume,turnover,turn_rate";
    public static final String FIND_QUOTE_KDJ_B = "k_b,d_b,j_b";
    public static final String FIND_QUOTE_MACD_B = "ema1_b,ema2_b,dea_b";
    public static final String FIND_QUOTE_RSI_B = "rsi1_b,rsi2_b,rsi3_b,sma_u1_b,sma_d1_b,sma_u2_b,sma_d2_b,sma_u3_b,sma_d3_b";

    public static final String FIND_QUOTE_BASE_F = "asset_id,date,open_f,high_f,low_f,close_f,pre_close_f,volume,turnover,turn_rate";
    public static final String FIND_QUOTE_KDJ_F = "k_f,d_f,j_f";
    public static final String FIND_QUOTE_MACD_F = "ema1_f,ema2_f,dea_f";
    public static final String FIND_QUOTE_RSI_F = "rsi1_f,rsi2_f,rsi3_f,sma_u1_f,sma_d1_f,sma_u2_f,sma_d2_f,sma_u3_f,sma_d3_f";

    /**
     * 查看周K基础数据时，拼接该列， 例如：select FIND_QUOTE_BASE + "," + FIND_QUOTE_WEEK_BASE from table
     */
    public static final String FIND_QUOTE_WEEK_BASE = "week_id";
    /**
     * 查看月K基础数据时，拼接该列， 例如：select FIND_QUOTE_BASE + "," + FIND_QUOTE_MONTH_BASE from table
     */
    public static final String FIND_QUOTE_MONTH_BASE = "month_id";

    /**
     *  新闻资讯首页查询获取列
     */
    public static final String FIND_NEWS_INDEX_INFO = "label_news_id,issue_time,title,gp,is_important,tag,is_live,img_url";

}
