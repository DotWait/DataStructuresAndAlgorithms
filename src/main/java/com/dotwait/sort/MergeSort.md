## 归并排序

**描述：**

> 归并排序——递归法，采用分治策略，是创建在归并操作上的一种有效的排序算法。
>
> ![img](https://images2017.cnblogs.com/blog/708993/201801/708993-20180111201741988-1257185279.png)

**代码如下：**

```java
private static void mergeSortAscend(int[] array, int low, int high) {
    if (low < high) {
        int mid = (low + high) / 2;
        mergeSortAscend(array, low, mid);
        mergeSortAscend(array, mid + 1, high);
        mergeAscend(array, low, mid, high);
    }
}
private static void mergeAscend(int[] array, int low, int mid, int high) {
    int length1 = mid - low + 1;
    int length2 = high - mid;
    int[] left = new int[length1 + 1];
    int[] right = new int[length2 + 1];
    int i;
    int j;
    for (i = 0; i < length1; i++) {
        left[i] = array[low + i];
    }
    left[length1] = MAX_INFINITY;
    for (j = 0; j < length2; j++) {
        right[j] = array[mid + j + 1];
    }
    i = 0;
    j = 0;
    right[length2] = MAX_INFINITY;
    for (int k = low; k <= high; k++) {
        if (left[i] > right[j]) {
            array[k] = right[j];
            j++;
        } else {
            array[k] = left[i];
            i++;
        }
    }
}
```

**算法分析：**

递归式：$T(n)=\begin{cases} \Theta(1)\quad,若n<=c\\ aT(n/b)+D(n)+C(n)\quad,其他\end{cases}$

分解：分解步骤需要计算子数组的中间位置，需要常量时间，$D(n)=\Theta(1)$

解决：递归求解两个规模均为n/2的子问题，需要$2T(n/2)$的运行时间

合并：一个具有n个元素的子数组上执行merge需要$\Theta(n)$的时间，所以$C(n)=\Theta(n)$

归并排序递归式：$T(n)=\begin{cases} \Theta(1)\quad,若n<=c\\ 2T(n/2)+\Theta(n)\quad,其他\end{cases}$

**求解递归式：**

主方法求解递归式：$a=2,b=2,f(n)=n$

$\because f(n)=\Theta(n^{\log_22})$

$\therefore T(n)=\Theta(n^{\log_22}\lg{n})=\Theta(n\lg{n})$

**时间复杂度：**$\Theta(n\lg{n})$

**空间复杂度：**$O(n)$

