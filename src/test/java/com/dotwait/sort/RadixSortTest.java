package com.dotwait.sort;

import com.dotwait.enums.Ordered;
import com.dotwait.util.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * 基数排序测试类
 *
 * @author DotWait
 * @Date 2019-12-15
 */
public class RadixSortTest {
    @Test
    public void radixSortTest(){
        int[] array = ArrayUtil.randomPositiveSequence(10000);
        RadixSort.sort(array);
        ArrayUtil.print(array);
        Assert.assertTrue(ArrayUtil.isOrdered(array, Ordered.ASCENDING));
    }
}
