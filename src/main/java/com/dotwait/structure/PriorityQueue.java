package com.dotwait.structure;


import com.dotwait.util.ArrayUtil;

/**
 * 优先队列
 *
 * @author DotWait
 * @Date 2019-12-01
 */
public class PriorityQueue {
    /**
     * 队列
     */
    private int[] queue;
    /**
     * 堆大小
     */
    private int heapSize;
    /**
     * 默认队列容量
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public PriorityQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public PriorityQueue(int initialCapacity) {
        this.queue = new int[initialCapacity];
        this.heapSize = 0;
    }

    public PriorityQueue(int[] queue, int heapSize) {
        if (heapSize > queue.length) {
            System.out.println("heapSize is error");
            return;
        }
        this.queue = queue;
        this.heapSize = heapSize;
    }

    /**
     * 插入一个新元素
     *
     * @param value 新元素的值
     */
    public void insert(int value) {
        if (heapSize == queue.length) {
            expansion();
        }
        heapSize++;
        queue[heapSize - 1] = Integer.MIN_VALUE;
        increaseKey(heapSize - 1, value);
    }

    /**
     * 获取队列中的最大值
     *
     * @return 最大值
     */
    public Integer getMaximum() {
        if (queue != null && heapSize > 0) {
            return queue[0];
        }
        return null;
    }

    /**
     * 去掉并返回queue中的最大值
     *
     * @return 最大值
     */
    public Integer extractMax() {
        if (heapSize < 1) {
            System.out.println("heap underflow");
            return null;
        }
        int max = queue[0];
        queue[0] = queue[heapSize - 1];
        heapSize--;
        Heap.maxHeapify(queue, heapSize, 0);
        return max;
    }

    /**
     * 将下标为index的元素值增长到value
     *
     * @param index 下标
     * @param value 增长到的值
     */
    public void increaseKey(int index, int value) {
        if (index >= heapSize) {
            System.out.println("index is error");
            return;
        }
        if (value < queue[index]) {
            System.out.println("new key is smaller than current key");
            return;
        }
        queue[index] = value;
        while (index > 0 && queue[index >> 1] < queue[index]) {
            Heap.exchange(queue, index >> 1, index);
            index = index >> 1;
        }
    }

    /**
     * 打印队列
     */
    public void print() {
        ArrayUtil.print(queue);
    }

    /**
     * 扩容 2倍
     */
    private void expansion() {
        int length = queue.length;
        int[] newQueue = new int[length << 1];
        System.arraycopy(queue, 0, newQueue, 0, length);
        queue = newQueue;
    }
}
