package com.dotwait.sort;

import java.util.ArrayList;
import java.util.List;

import static com.dotwait.util.ArrayUtil.getMax;

/**
 * 基数排序
 * 输入：n个数的一个序列<a1, a2, ..., an>
 *     输入要求：输入的元素每一个都是0到k区间内的一个整数
 * 输出：输入序列的一个排列<a1', a2', ..., an'>，满足a1'<=a2'<=...<=an'
 *
 * @author DotWait
 * @Date 2019-12-15
 */
public class RadixSort {
    /**
     * 升序排序
     * 输入要求：输入的元素每一个都是0到k区间内的一个整数
     *
     * @param array 待排序数组
     */
    public static void sort(int[] array) {
        /*获取最大值*/
        Integer max = getMax(array);
        if (max == null) {
            return;
        }
        /*获取最大值的位数*/
        int digit = getDigit(max);
        List<List<Integer>> buckets = new ArrayList<>();
        /*初始化数字0-9的桶*/
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<Integer>());
        }
        /*从低位往高位遍历*/
        for (int i = 0; i < digit; i++) {
            /*将array中的数放入桶中*/
            for (int j = 0; j < array.length; j++) {
                /*获取数字指定位数上的数字*/
                int key = (int) (array[j] % (Math.pow(10, i + 1)) / (Math.pow(10, i)));
                /*根据位数上的数字将对应的数放入对应的桶中*/
                buckets.get(key).add(array[j]);
            }
            int index = 0;
            /*从低到高开始遍历桶，将数字有序赋值给array，若从高到低遍历则为降序*/
            System.out.println("size:"+buckets.size());
            for (int j = 0; j < buckets.size(); j++) {
                List<Integer> bucket = buckets.get(j);
                while (bucket.size() > 0){
                    array[index++] = bucket.remove(0);
                }
            }
        }
    }

    /**
     * 获取一个数的位数
     *
     * @param num 数字
     * @return 位数
     */
    private static Integer getDigit(int num) {
        return (int) Math.log10(num) + 1;
    }
}
