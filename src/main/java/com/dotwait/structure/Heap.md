## 堆结构分析

#### 1. maxHeapify分析

> 维护最大堆性质的重要过程
> 前提：假定了index的左子树和右子树均为最大堆，此时array[index]可能小于其孩子节点，这违背了最大堆的性质，maxHeapify让array[index]的值在最大堆中逐级下降，使下标为index，根节点的子树重新遵循最大堆的性质

**代码如下：**

```java
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
```

**算法分析：**

调整index和index的左右子节点的时间代价为$O(1)$，加上maxHeapify在index孩子节点上运行的时间代价（递归调用的时间代价）。每个孩子节点的子树的大小至多为$2n/3$（最坏情况发生在树的最底层恰好半满的时候）。

**运行时间：**

$T(n)<=T(2n/3)+O(1)$

根据主定理计算得：$T(n)=O(\lg{n})$

在高度为h的树中，maxHeapify的时间复杂度为$O(h)$

**时间复杂度：**$O(\lg{n})$

**空间复杂度：**$O(1)$

#### 2. buildMaxHeap分析

> 建立最大堆分析

**代码如下：**

```java
public static void buildMaxHeap(int[] array, int heapSize) {
    for (int i = (heapSize - 1) / 2; i >= 0; i--) {
        maxHeapify(array, heapSize, i);
    }
}
```

**算法分析：**

每次调用maxHeapify需要$O(\log{n})$，buildMaxHeap需要调用$O(n)$次，因此总的时间复杂度是$O(n\lg{n})$，此上界虽正确，但不是渐进紧确的。
不同节点运行maxHeapify的时间与该节点的树高有关，大部分节点的高度都很小，因此可以获得一个更加紧确的界。

**运行时间：**

包含n个元素的堆的高度为$\llcorner\lg{n}\lrcorner$，高度为h的堆最多包含$\ulcorner n/2^{h+1}\urcorner$个节点。

高度为h的节点上运行maxHeapify的代价是$O(h)$，buildMaxHeap的总代价为：

$\sum_{h=0}^{\llcorner\lg{n}\lrcorner}{\ulcorner \frac{n}{2^{h+1}}\urcorner}O(h)=O(n\sum_{h=0}^{\llcorner\lg{n}\lrcorner}{\frac{h}{2^h}})$

$\because \sum_{h=0}^{\propto}{\frac{h}{2^h}}=\frac{1/2}{(1-1/2)^2}=2$

$\therefore O(n\sum_{h=0}^{\llcorner\lg{n}\lrcorner}{\frac{h}{2^h}})=O(n\sum_{h=0}^{\propto}{\frac{h}{2^h}})=O(n)$

因此，把一个无序数组构造成一个最大堆需要$O(n)$

**时间复杂度：**$O(n) $

**空间复杂度：**$O(1) $

