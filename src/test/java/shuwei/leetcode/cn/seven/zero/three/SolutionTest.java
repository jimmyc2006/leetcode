package shuwei.leetcode.cn.seven.zero.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        KthLargest test = new KthLargest(3, new int[]{4, 5, 8, 2});
        Assert.assertEquals(4, test.add(3));
        Assert.assertEquals(5, test.add(5));
        Assert.assertEquals(5, test.add(9));
        Assert.assertEquals(8, test.add(10));
    }

    @Test
    public void test2() {
        KthLargest test = new KthLargest(1, new int[]{4});
        Assert.assertEquals(4, test.add(3));
    }

    @Test
    public void test3() {
        KthLargest test = new KthLargest(2, new int[]{0});
        Assert.assertEquals(-1, test.add(-1));
        Assert.assertEquals(0, test.add(1));
        Assert.assertEquals(0, test.add(-2));
        Assert.assertEquals(0, test.add(-4));
        Assert.assertEquals(1, test.add(3));
    }
}
