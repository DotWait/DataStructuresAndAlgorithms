package com.dotwait.sort;

import static com.dotwait.util.ArrayUtil.getMax;

/**
 * 计数排序
 * 输入：n个数的一个序列<a1, a2, ..., an>
 * 输入要求：输入的元素每一个都是0到k区间内的一个整数
 * 输出：输入序列的一个排列<a1', a2', ..., an'>，满足a1'<=a2'<=...<=an'
 *
 * @author DotWait
 * @Date 2019-12-15
 */
public class CountingSort {
    /**
     * 升序排序
     * 输入要求：输入的元素每一个都是0到k区间内的一个整数
     *
     * @param array 数组
     * @return 排序后的数组
     */
    public static int[] sort(int[] array) {
        /*获取数组中的最大只*/
        Integer max = getMax(array);
        System.out.println("max==>"+max);
        if (max == null) {
            return new int[0];
        }
        int[] temp = new int[max+1];
        int[] result = new int[array.length];
        /*每一个数在数组对应的下标的值+1*/
        for (int i = 0; i < array.length; i++) {
            temp[array[i]] = temp[array[i]] + 1;
        }
        /*前一个值+当前值*/
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i] + temp[i - 1];
        }
        /*输出到结果数组上*/
        for (int i = array.length - 1; i >= 0; i--) {
            result[temp[array[i]]-1] = array[i];
            temp[array[i]] = temp[array[i]] - 1;
        }
        return result;
    }
}
