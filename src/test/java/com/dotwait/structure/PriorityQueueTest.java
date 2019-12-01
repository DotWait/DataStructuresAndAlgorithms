package com.dotwait.structure;

import org.junit.Assert;
import org.junit.Test;

/**
 * 优先队列测试类
 *
 * @author DotWait
 * @Date 2019-12-01
 */
public class PriorityQueueTest {
    @Test
    public void priorityQueueTest(){
        PriorityQueue queue = new PriorityQueue();
        Integer max1 = queue.getMaximum();
        Assert.assertNull(max1);
        Integer max2 = queue.extractMax();
        Assert.assertNull(max2);
        queue.increaseKey(1, 4);
        queue.increaseKey(0, 5);
        Integer max3 = queue.extractMax();
        Assert.assertNull(max3);
        Integer max4 = queue.getMaximum();
        Assert.assertNull(max4);
        queue.insert(2);
        queue.insert(5);
        queue.insert(8);
        queue.insert(4);
        queue.print();
    }
}
