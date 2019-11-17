package com.dotwait.sort;

import com.dotwait.enums.Ordered;

/**
 * 归并排序
 * 输入：n个数的一个序列<a1, a2, ..., an>
 * 输出：输入序列的一个排列<a1', a2', ..., an'>，满足a1'<=a2'<=...<=an'
 *
 * @author DotWait
 * @Date 2019-11-17
 */
public class MergeSort {
    /**
     * 正无穷
     */
    private static final int MAX_INFINITY = Integer.MAX_VALUE;
    /**
     * 负无穷
     */
    private static final int MIN_INFINITY = Integer.MIN_VALUE;

    /**
     * 排序
     *
     * @param array   待排序数组
     * @param ordered 排序方式：升序 or 降序
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
    public static void sortAscend(int[] array) {
        mergeSortAscend(array, 0, array.length - 1);
    }

    /**
     * 降序排序
     *
     * @param array 待排序数组
     */
    public static void sortDescend(int[] array) {
        mergeSortDescend(array, 0, array.length - 1);
    }

    /**
     * 归并排序递归式——升序
     *
     * @param array 待排序数组
     * @param low   排序最低下标
     * @param high  排序最高下标
     */
    private static void mergeSortAscend(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSortAscend(array, low, mid);
            mergeSortAscend(array, mid + 1, high);
            mergeAscend(array, low, mid, high);
        }
    }

    /**
     * 归并排序合并阶段——升序
     *
     * @param array 待排序数组
     * @param low   排序最低下标
     * @param mid   中间下标值
     * @param high  排序最大下标
     */
    private static void mergeAscend(int[] array, int low, int mid, int high) {
        int length1 = mid - low + 1;
        int length2 = high - mid;
        int[] left = new int[length1 + 1];
        int[] right = new int[length2 + 1];
        int i;
        int j;
        for (i = 0; i < length1; i++) {
            left[i] = array[low + i];
        }
        left[length1] = MAX_INFINITY;
        for (j = 0; j < length2; j++) {
            right[j] = array[mid + j + 1];
        }
        i = 0;
        j = 0;
        right[length2] = MAX_INFINITY;
        for (int k = low; k <= high; k++) {
            if (left[i] > right[j]) {
                array[k] = right[j];
                j++;
            } else {
                array[k] = left[i];
                i++;
            }
        }
    }

    /**
     * 归并排序递归式——降序
     *
     * @param array 待排序数组
     * @param low   排序最低下标
     * @param high  排序最高下标
     */
    private static void mergeSortDescend(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSortDescend(array, low, mid);
            mergeSortDescend(array, mid + 1, high);
            mergeDescend(array, low, mid, high);
        }
    }

    /**
     * 归并排序合并阶段——降序
     *
     * @param array 待排序数组
     * @param low   排序最低下标
     * @param mid   中间下标值
     * @param high  排序最大下标
     */
    private static void mergeDescend(int[] array, int low, int mid, int high) {
        int length1 = mid - low + 1;
        int length2 = high - mid;
        int[] left = new int[length1 + 1];
        int[] right = new int[length2 + 1];
        int i;
        int j;
        for (i = 0; i < length1; i++) {
            left[i] = array[low + i];
        }
        left[length1] = MIN_INFINITY;
        for (j = 0; j < length2; j++) {
            right[j] = array[mid + j + 1];
        }
        i = 0;
        j = 0;
        right[length2] = MIN_INFINITY;
        for (int k = low; k <= high; k++) {
            if (left[i] <= right[j]) {
                array[k] = right[j];
                j++;
            } else {
                array[k] = left[i];
                i++;
            }
        }
    }
}
