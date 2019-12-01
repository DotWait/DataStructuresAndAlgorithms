package com.dotwait.sort;

import com.dotwait.enums.Ordered;
import com.dotwait.util.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * 堆排序测试类
 *
 * @author DotWait
 * @Date 2019-12-01
 */
public class HeapSortTest {
    @Test
    public void heapSortTest(){
        sortTest(Ordered.ASCENDING);
        sortTest(Ordered.DESCENDING);
    }

    private void sortTest(Ordered ordered){
        int[] array = ArrayUtil.randomSequence();
        HeapSort.sort(array, ordered);
        ArrayUtil.print(array);
        Assert.assertTrue(ArrayUtil.isOrdered(array, ordered));
    }
}
