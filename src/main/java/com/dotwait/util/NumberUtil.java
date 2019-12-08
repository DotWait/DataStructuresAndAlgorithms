package com.dotwait.util;

import java.util.Random;

/**
 * 数字工具类
 *
 * @author DotWait
 * @Date 2019-12-08
 */
public class NumberUtil {
    /**
     * 随机数生成器
     */
    private static Random random = new Random();

    /**
     * 随机生成指定范围内的数字
     *
     * @param lowerBound 下界
     * @param upperBound 上界
     * @return 随机数
     */
    public static int random(int lowerBound, int upperBound) {
        if (upperBound < lowerBound) {
            throw new IllegalArgumentException("上界不能小于下界");
        }
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
}
