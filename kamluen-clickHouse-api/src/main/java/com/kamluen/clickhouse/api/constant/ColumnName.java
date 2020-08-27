package com.kamluen.clickhouse.api.constant;

public class ColumnName {

    /**
     * 行情历史K线相关表列名
     */
    // 公共列
    public static final String ASSET_ID = "asset_id";
    public static final String WEEK_ID = "week_id";     //周K仅有
    public static final String MONTH_ID = "month_id";   //月K仅有
    public static final String DATE = "date";

    // 不复权列
    public static final String OPEN = "open";
    public static final String HIGH = "high";
    public static final String LOW = "low";
    public static final String CLOSE = "close";
    public static final String PRE_CLOSE = "pre_close";
    public static final String VOLUME = "volume";
    public static final String TURNOVER = "turnover";
    public static final String TURN_RATE = "turn_rate";
    public static final String K = "k";
    public static final String D = "d";
    public static final String J = "j";
    public static final String EMA_1 = "ema1";
    public static final String EMA_2 = "ema2";
    public static final String DEA = "dea";
    public static final String RSI_1 = "rsi1";
    public static final String RSI_2 = "rsi2";
    public static final String RSI_3 = "rsi3";
    public static final String SMA_U_1 = "sma_u1";
    public static final String SMA_D_1 = "sma_d1";
    public static final String SMA_U_2 = "sma_u2";
    public static final String SMA_D_2 = "sma_d2";
    public static final String SMA_U_3 = "sma_u3";
    public static final String SMA_D_3 = "sma_d3";

    // 前复权列
    public static final String OPEN_F = "open_f";
    public static final String HIGH_F = "high_f";
    public static final String LOW_F = "low_f";
    public static final String CLOSE_F = "close_f";
    public static final String PRE_CLOSE_F = "pre_close_f";
//    public static final String VOLUME_F = "volume_f";
//    public static final String TURNOVER_F = "turnover_f";
//    public static final String TURN_RATE_F = "turn_rate_f";
    public static final String K_F = "k_f";
    public static final String D_F = "d_f";
    public static final String J_F = "j_f";
    public static final String EMA_1_F = "ema1_f";
    public static final String EMA_2_F = "ema2_f";
    public static final String DEA_F = "dea_f";
    public static final String RSI_1_F = "rsi1_f";
    public static final String RSI_2_F = "rsi2_f";
    public static final String RSI_3_F = "rsi3_f";
    public static final String SMA_U_1_F = "sma_u1_f";
    public static final String SMA_D_1_F = "sma_d1_f";
    public static final String SMA_U_2_F = "sma_u2_f";
    public static final String SMA_D_2_F = "sma_d2_f";
    public static final String SMA_U_3_F = "sma_u3_f";
    public static final String SMA_D_3_F = "sma_d3_f";

    // 后复权列
    public static final String OPEN_B = "open_b";
    public static final String HIGH_B = "high_b";
    public static final String LOW_B = "low_b";
    public static final String CLOSE_B = "close_b";
    public static final String PRE_CLOSE_B = "pre_close_b";
//    public static final String VOLUME_B = "volume_b";
//    public static final String TURNOVER_B = "turnover_b";
//    public static final String TURN_RATE_B = "turn_rate_b";
    public static final String K_B = "k_b";
    public static final String D_B = "d_b";
    public static final String J_B = "j_b";
    public static final String EMA_1_B = "ema1_b";
    public static final String EMA_2_B = "ema2_b";
    public static final String DEA_B = "dea_b";
    public static final String RSI_1_B = "rsi1_b";
    public static final String RSI_2_B = "rsi2_b";
    public static final String RSI_3_B = "rsi3_b";
    public static final String SMA_U_1_B = "sma_u1_b";
    public static final String SMA_D_1_B = "sma_d1_b";
    public static final String SMA_U_2_B = "sma_u2_b";
    public static final String SMA_D_2_B = "sma_d2_b";
    public static final String SMA_U_3_B = "sma_u3_b";
    public static final String SMA_D_3_B = "sma_d3_b";

}
