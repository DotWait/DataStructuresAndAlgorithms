## 堆排序分析

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

**时间复杂度：**$O(n\lg{n]})$

**空间复杂度：**$O(1)$