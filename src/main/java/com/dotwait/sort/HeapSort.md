## 堆排序分析

**描述：**

> 堆排序利用堆这种数据结构设计的一种排序算法，堆是一个近似完全二叉树的结构，并同时满足堆积的性质。即子节点的键值或索引总是小于（或者大于）它的父节点。
>
> 堆排序每次取大顶堆中的最大元素，取出最大元素后，剩余元素重新构成大顶堆，再取最大元素，以此类推。n个元素取n-1次即可完成排序。（小顶堆类似）
>
> ![å¤§é¡¶å åå°é¡¶å ](https://kingsfish.github.io/2018/09/24/%E5%A0%86%E6%8E%92%E5%BA%8F%E9%97%AE%E9%A2%98/heap.jpg)

**代码如下：**

```java
public static void sortAscend(int[] array) {
    int heapSize = array.length;
    Heap.buildMaxHeap(array, heapSize);
    for (int i = array.length - 1; i > 0; i--) {
        Heap.exchange(array, 0, i);
        heapSize--;
        Heap.maxHeapify(array, heapSize, 0);
    }
}
```

**算法分析：**

第3行buildMaxHeap建立最大堆的时间代价为$O(n)$，maxHeapify的时间代价为$O(\lg{n})$，for循环的时间代价为$O(n\lg{n})$，堆排序的总的时间代价为$O(n)+O(n\lg{n})=O(n\lg{{n}})$。、

**时间复杂度：**$O(n\lg{n})$

**空间复杂度：**$O(1)$