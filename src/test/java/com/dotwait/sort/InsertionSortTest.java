package com.dotwait.sort;

import com.dotwait.enums.Ordered;
import com.dotwait.util.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * 插入排序测试类
 *
 * @author DotWait
 * @Date 2019-11-17
 */
public class InsertionSortTest {
    @Test
    public void insertionSortTest(){
        sortTest(Ordered.ASCENDING);
        sortTest(Ordered.DESCENDING);
    }

    private void sortTest(Ordered ordered){
        int[] array = ArrayUtil.randomSequence();
        InsertionSort.sort(array, ordered);
        ArrayUtil.print(array);
        Assert.assertTrue(ArrayUtil.isOrdered(array, ordered));
    }
}
