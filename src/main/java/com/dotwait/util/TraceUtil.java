package com.dotwait.util;

import com.dotwait.enums.TimeUnit;

/**
 * 耗时打印工具
 *
 * @author DotWait
 * @Date 2019-12-01
 */
public class TraceUtil {
    /**
     * 开始时间
     */
    private long start;
    /**
     * 暂停时间
     */
    private long end;
    /**
     * 时间单位
     */
    private TimeUnit timeUnit = TimeUnit.MILLIS;

    public TraceUtil() {
        System.out.println("========开始计时=======");
        start = System.currentTimeMillis();
    }

    public TraceUtil(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
        System.out.println("========开始计时=======");
        start = System.currentTimeMillis();
    }

    /**
     * 暂停查看
     */
    public void stop() {
        end = System.currentTimeMillis();
        System.out.println("=====暂停查看，总耗时：" + (end - start) / timeUnit.getValue() + timeUnit.getDescCN());
    }

    /**
     * 暂停查看
     * @param message 自定义日志打印
     */
    public void stop(String message) {
        end = System.currentTimeMillis();
        System.out.println("=====" + message + "，总耗时：" + (end - start) / timeUnit.getValue() + timeUnit.getDescCN());
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
}
