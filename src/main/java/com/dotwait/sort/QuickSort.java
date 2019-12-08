package com.dotwait.sort;

import com.dotwait.enums.Ordered;

import static com.dotwait.util.ArrayUtil.exchange;
import static com.dotwait.util.NumberUtil.random;

/**
 * 快速排序
 * 输入：n个数的一个序列<a1, a2, ..., an>
 * 输出：输入序列的一个排列<a1', a2', ..., an'>，满足a1'<=a2'<=...<=an'
 *
 * @author DotWait
 * @Date 2019-12-08
 */
public class QuickSort {
    /**
     * 排序
     *
     * @param array   待排序数组
     * @param ordered 排序方式；升序 or 降序
     */
    public static void sort(int[] array, Ordered ordered) {
        if (Ordered.ASCENDING.equals(ordered)) {
            sortAscend(array);
        } else if (Ordered.DESCENDING.equals(ordered)) {
            sortDescend(array);
        }
    }

    /**
     * 升序排序
     *
     * @param array 待排序数组
     */
    private static void sortAscend(int[] array) {
        quickSortAscend(array, 0, array.length - 1);
    }

    /**
     * 降序排序
     *
     * @param array 待排序数组
     */
    private static void sortDescend(int[] array) {
        quickSortDescend(array, 0, array.length - 1);
    }

    /**
     * 快排升序
     *
     * @param array 待排序数组
     * @param low   开始下标
     * @param high  结束下标
     */
    private static void quickSortAscend(int[] array, int low, int high) {
        if (high > low) {
            int partition = randomizedPartitionAscend(array, low, high);
            quickSortAscend(array, low, partition - 1);
            quickSortAscend(array, partition + 1, high);
        }
    }

    /**
     * 分区方法  升序
     *
     * @param array 待分区数组
     * @param low   开始下标
     * @param high  结束下标
     * @return 分区点
     */
    private static int randomizedPartitionAscend(int[] array, int low, int high) {
        int i = low;
        //随机选择partition位置
        int p = random(low, high);
        exchange(array, p, high);
        for (int j = low; j < high; j++) {
            if (array[high] > array[j]) {
                exchange(array, j, i);
                i++;
            }
        }
        exchange(array, i, high);
        return i;
    }

    /**
     * 快排降序
     *
     * @param array 待排序数组
     * @param low   开始下标
     * @param high  结束下标
     */
    private static void quickSortDescend(int[] array, int low, int high) {
        if (high > low) {
            int partition = randomizedPartitionDescend(array, low, high);
            quickSortDescend(array, low, partition - 1);
            quickSortDescend(array, partition + 1, high);
        }
    }

    /**
     * 分区方法  降序
     *
     * @param array 待分区数组
     * @param low   开始下标
     * @param high  结束下标
     * @return 分区点
     */
    private static int randomizedPartitionDescend(int[] array, int low, int high) {
        int i = low;
        //随机选择partition位置
        int p = random(low, high);
        exchange(array, p, high);
        for (int j = low; j < high; j++) {
            if (array[high] < array[j]) {
                exchange(array, j, i);
                i++;
            }
        }
        exchange(array, i, high);
        return i;
    }
}
