package com.dotwait.sort;

import com.dotwait.enums.Ordered;
import com.dotwait.util.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * 归并排序测试类
 *
 * @author DotWait
 * @Date 2019-11-17
 */
public class MergeSortTest {
    @Test
    public void mergeSortTest(){
        sortTest(Ordered.ASCENDING);
        sortTest(Ordered.DESCENDING);
    }

    private void sortTest(Ordered ordered){
        int[] array = ArrayUtil.randomSequence();
        MergeSort.sort(array, ordered);
        ArrayUtil.print(array);
        Assert.assertTrue(ArrayUtil.isOrdered(array, ordered));
    }
}
