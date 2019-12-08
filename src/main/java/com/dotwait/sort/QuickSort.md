## 快速排序分析

**描述：**

> **快速排序**，又称**划分交换排序**，简称**快排**.在平均状况下，排序n个项目要$O(n\lg{n})$次比较。在最坏状况下则需要$O(n^2)$次比较，但这种状况并不常见。事实上，快速排序$O(n\lg{n})$通常明显比其他算法更快，因为它的内部循环可以在大部分的架构上很有效率地达成。
>
> ![](https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Partition_example.svg/400px-Partition_example.svg.png)

**代码如下：**

```java
/**
* 快排升序
*
* @param array 待排序数组
* @param low   开始下标
* @param high  结束下标
*/
public static void quickSortAscend(int[] array, int low, int high) {
    if (high > low) {
        int partition = randomizedPartitionAscend(array, low, high);
        quickSortAscend(array, low, partition - 1);
        quickSortAscend(array, partition + 1, high);
    }
}
/**
* 分区（划分）方法  升序
*
* @param array 待分区数组
* @param low   开始下标
* @param high  结束下标
* @return 分区（划分）点
*/
private static int randomizedPartitionAscend(int[] array, int low, int high) {
    int i = low;
    //随机选择partition位置
    int p = random(low, high);
    exchange(array, p, high);
    for (int j = low; j < high; j++) {
        if (array[high] > array[j]) {
            exchange(array, j, i);
            i++;
        }
    }
    exchange(array, i, high);
    return i;
}
```

**算法分析：**

> 与归并排序类似，快排使用了分治思想，分治过程：
>
> **分解：** array[low...high]被划分为两个（可能为空）子数组array[low...p-1]和array[p+1...high]，其中，array[low...p-1]每个元素都小于等于array[p]，array[p+1...high]中每个元素都大于等于array[p]。
>
> **解决：** 递归调用快排，对划分后的子数组array[low...p-1]和array[p+1...high]排序
>
> **合并：** 子数组是原址排序，不需要合并

**性能分析：**

> 快排的运行时间依赖于子数组的划分是否平衡，而子数组划分的平衡与否又依赖于用于划分的元素。

1. 最坏情况划分：划分产生的两个子问题分别包含了n-1个元素和0个元素

   划分操作的时间复杂度为$\Theta(n)$。

   对一个0个元素的数组递归调用会直接返回，因此$T(0)=\Theta(1)$。

   综上算法运行时间的递归式为：$T(n)=T(n-1)+T(0)+\Theta(n)=T(n-1)+\Theta(n)$。每层递归的代价$\Theta(n)$累加，共n层，因此$T(n)=\Theta(n^2)$。

2. 最好情况划分：两个子数组的规模都不大于n/2

   划分操作的时间复杂度为$\Theta(n)$。

   算法运行时间的递归式为：$T(n)=2T(n/2)+\Theta(n)$。因此$T(n)=\Theta(n\log{n})$。

3. 平均情况：快排的平均运行时间更接近于最好情况，时间复杂度为$T(n)=\Theta(n\lg{n})$。为了引入随机性，使算法达到平均情况的性能，在划分子数组时使用随机选取划分点的方法。