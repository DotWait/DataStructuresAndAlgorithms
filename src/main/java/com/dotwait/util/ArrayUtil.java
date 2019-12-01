package com.dotwait.util;

import com.dotwait.enums.Ordered;

import java.util.Random;

/**
 * 数组工具类
 *
 * @author DotWait
 * @Date 2019-11-17
 */
public class ArrayUtil {
    /**
     * 随机数生成器
     */
    private static Random random = new Random();

    /**
     * 随机产生一个int
     *
     * @return 随机的int
     */
    private static int randomInt() {
        return random.nextInt();
    }

    /**
     * 随机产生一个正整数
     *
     * @return 随机正整数
     */
    private static int randomPositiveInt() {
        return random.nextInt(100000);
    }

    /**
     * 随机产生一个数组序列，数组长度随机
     *
     * @return 随机的数组序列
     */
    public static int[] randomSequence() {
        return randomSequence(randomPositiveInt());
    }

    /**
     * 随机产生一个数组序列
     *
     * @param length 指定数组的长度
     * @return 随机的数组序列
     */
    public static int[] randomSequence(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = randomInt();
        }
        return array;
    }

    /**
     * 验证数组是否有序
     *
     * @param array   待验证舒徐
     * @param ordered 排序方式：升序 or 降序
     * @return 是否有序
     */
    public static boolean isOrdered(final int[] array, Ordered ordered) {
        if (Ordered.ASCENDING.equals(ordered)) {
            //升序
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    System.out.println("index1 => " + i + ", index2 => " + (i + 1));
                    System.out.println("int1 => " + array[i] + ", int2 => " + array[i + 1]);
                    return false;
                }
            }
            return true;
        } else if (Ordered.DESCENDING.equals(ordered)) {
            //降序
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    System.out.println("index1 => " + i + ", index2 => " + (i + 1));
                    System.out.println("int1 => " + array[i] + ", int2 => " + array[i + 1]);
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 打印数组
     *
     * @param array 数组
     */
    public static void print(final int... array) {
        System.out.println("======start print=========");
        int count = 10;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
            if ((i + 1) % count == 0) {
                System.out.println();
            }
        }
        System.out.println("\n=======end print==========");
    }

    /**
     * 获取一个简单的数组，用于debug
     *
     * @return 简单数组
     */
    public static int[] simpleArray() {
        return new int[]{5, 2, 1, 6, 7, 3, 9};
    }
}
