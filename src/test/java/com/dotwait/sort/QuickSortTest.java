package com.dotwait.sort;

import com.dotwait.enums.Ordered;
import com.dotwait.util.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * 快速排序测试类
 *
 * @author DotWait
 * @Date 2019-12-08
 */
public class QuickSortTest {
    @Test
    public void quickSortTest(){
        sortTest(Ordered.ASCENDING);
        sortTest(Ordered.DESCENDING);
    }

    private void sortTest(Ordered ordered){
        int[] array = ArrayUtil.randomSequence()  ;
        QuickSort.sort(array, ordered);
        ArrayUtil.print(array);
        Assert.assertTrue(ArrayUtil.isOrdered(array, ordered));
    }
}
