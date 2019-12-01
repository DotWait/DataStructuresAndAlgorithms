package com.dotwait.enums;

/**
 * 时间单位
 *
 * @author DotWait
 * @Date 2019-12-01
 */
public enum TimeUnit {
    MILLIS(1L, "毫秒"),
    SECOND(1000L, "秒"),
    MINUTE(1000L*60, "分钟"),
    HOUR(1000L*60*60, "小时"),
    DAY(1000L*60*60*24, "天");

    private long value;
    private String descCN;

    TimeUnit(long value, String descCN) {
        this.value = value;
        this.descCN = descCN;
    }

    public long getValue() {
        return value;
    }

    public String getDescCN() {
        return descCN;
    }
}
