package com.dotwait.sort;

import com.dotwait.enums.Ordered;

/**
 * 插入排序
 * 输入：n个数的一个序列<a1, a2, ..., an>
 * 输出：输入序列的一个排列<a1', a2', ..., an'>，满足a1'<=a2'<=...<=an'
 *
 * @author DotWait
 * @Date 2019-11-17
 */
public class InsertionSort {
    /**
     * 排序
     * @param array 待排序数组
     * @param ordered 排序方式；升序 or 降序
     */
    public static void sort(int[] array, Ordered ordered){
        if (Ordered.ASCENDING.equals(ordered)){
            //升序
            sortAscend(array);
        }else if(Ordered.DESCENDING.equals(ordered)){
            //降序
            sortDescend(array);
        }
    }

    /**
     * 升序排序
     * @param array 待排序数组
     */
    public static void sortAscend(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            for (; j >= 0 && key < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }

    /**
     * 降序排序
     * @param array 待排序数组
     */
    public static void sortDescend(int[] array){
        for (int i=1;i<array.length;i++){
            int key = array[i];
            int j = i-1;
            for (; j>=0 && key > array[j];j--){
                array[j+1] = array[j];
            }
            array[j+1] = key;
        }
    }
}
