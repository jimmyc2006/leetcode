package shuwei.leetcode.cn.two.three.nine;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[]{1, -1}, s.maxSlidingWindow(new int[]{1, -1}, 1));
        Assert.assertArrayEquals(new int[]{7, 4}, s.maxSlidingWindow(new int[]{7, 2, 4}, 2));
        Assert.assertArrayEquals(new int[]{11}, s.maxSlidingWindow(new int[]{9, 11}, 2));
        Assert.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        Assert.assertArrayEquals(new int[]{1}, s.maxSlidingWindow(new int[]{1}, 1));
        Assert.assertArrayEquals(new int[]{4}, s.maxSlidingWindow(new int[]{4, -2}, 2));
    }
}
