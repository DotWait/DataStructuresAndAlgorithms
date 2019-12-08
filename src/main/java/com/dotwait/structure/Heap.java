package com.dotwait.structure;

import static com.dotwait.util.ArrayUtil.exchange;

/**
 * 堆
 * 基本操作和性质
 *
 * @author DotWait
 * @Date 2019-12-01
 */
public class Heap {
    /**
     * 维护最大堆性质的重要过程
     * 前提：假定了index的左子树和右子树均为最大堆，此时array[index]可能小于其孩子节点，
     * 这违背了最大堆的性质，maxHeapify让array[index]的值在最大堆中逐级下降，使下标为index
     * 根节点的子树重新遵循最大堆的性质
     * 时间复杂度：O(lg(n))
     * 空间复杂度：O(1)
     *
     * @param array    数组
     * @param heapSize 堆大小
     * @param index    下标
     */
    public static void maxHeapify(int[] array, int heapSize, int index) {
        /*获取index儿子节点的下标*/
        int left = index << 1;
        int right = (index << 1) + 1;
        /*获取index 左儿子 右儿子三个节点中值最大节点的下标*/
        int maxIndex = index;
        if (left < heapSize && array[left] > array[index]) {
            maxIndex = left;
        }
        if (right < heapSize && array[right] > array[maxIndex]) {
            maxIndex = right;
        }
        /*最大值节点置于父节点位置*/
        if (maxIndex != index) {
            exchange(array, index, maxIndex);
            maxHeapify(array, heapSize, maxIndex);
        }
    }

    /**
     * 建最大堆
     * 自底向上的方法利用maxHeapify建堆
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param array    数组
     * @param heapSize 堆大小
     */
    public static void buildMaxHeap(int[] array, int heapSize) {
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            maxHeapify(array, heapSize, i);
        }
    }

    /**
     * 维护最小堆性质的重要过程
     * 前提：假定了index的左子树和右子树均为最小堆，此时array[index]可能大于其孩子节点，
     * 这违背了最小堆的性质，minHeapify让array[index]的值在最小堆中逐级下降，使下标为index
     * 根节点的子树重新遵循最小堆的性质
     * 时间复杂度：O(lg(n))
     * 空间复杂度：O(1)
     *
     * @param array    数组
     * @param heapSize 堆大小
     * @param index    下标
     */
    public static void minHeapify(int[] array, int heapSize, int index) {
        /*获取index儿子节点的下标*/
        int left = index << 1;
        int right = (index << 1) + 1;
        /*获取index 左儿子 右儿子三个节点中值最小节点的下标*/
        int minIndex = index;
        if (left < heapSize && array[left] < array[index]) {
            minIndex = left;
        }
        if (right < heapSize && array[right] < array[minIndex]) {
            minIndex = right;
        }
        /*最小值节点置于父节点位置*/
        if (minIndex != index) {
            exchange(array, index, minIndex);
            minHeapify(array, heapSize, minIndex);
        }
    }

    /**
     * 建最小堆
     * 自底向上的方法利用maxHeapify建堆
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param array    数组
     * @param heapSize 堆大小
     */
    public static void buildMinHeap(int[] array, int heapSize) {
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            minHeapify(array, heapSize, i);
        }
    }
}
