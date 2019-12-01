package com.dotwait.sort;

import com.dotwait.enums.Ordered;
import com.dotwait.structure.Heap;

/**
 * 堆排序
 * 输入：n个数的一个序列<a1, a2, ..., an>
 * 输出：输入序列的一个排列<a1', a2', ..., an'>，满足a1'<=a2'<=...<=an'
 *
 * @author DotWait
 * @Date 2019-12-01
 */
public class HeapSort {
    /**
     * 排序
     *
     * @param array   待排序数组
     * @param ordered 排序方式；升序 or 降序
     */
    public static void sort(int[] array, Ordered ordered) {
        if (Ordered.ASCENDING.equals(ordered)) {
            //升序
            sortAscend(array);
        } else if (Ordered.DESCENDING.equals(ordered)) {
            //降序
            sortDescend(array);
        }
    }

    /**
     * 升序排序
     *
     * @param array 待排序数组
     */
    public static void sortAscend(int[] array) {
        int heapSize = array.length;
        Heap.buildMaxHeap(array, heapSize);
        for (int i = array.length - 1; i > 0; i--) {
            Heap.exchange(array, 0, i);
            heapSize--;
            Heap.maxHeapify(array, heapSize, 0);
        }
    }

    /**
     * 降序排序
     *
     * @param array 待排序数组
     */
    public static void sortDescend(int[] array) {
        int heapSize = array.length;
        Heap.buildMinHeap(array, heapSize);
        for (int i = array.length - 1; i > 0; i--) {
            Heap.exchange(array, 0, i);
            heapSize--;
            Heap.minHeapify(array, heapSize, 0);
        }
    }
}
