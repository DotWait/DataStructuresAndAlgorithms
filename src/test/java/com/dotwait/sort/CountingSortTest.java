package com.dotwait.sort;

import com.dotwait.enums.Ordered;
import com.dotwait.util.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * 计数排序测试类
 *
 * @author DotWait
 * @Date 2019-12-15
 */
public class CountingSortTest {
    @Test
    public void countingSortTest(){
        int[] array = ArrayUtil.randomPositiveSequence(10000);
        int[] result = CountingSort.sort(array);
        ArrayUtil.print(result);
        Assert.assertTrue(ArrayUtil.isOrdered(result, Ordered.ASCENDING));
    }
}
