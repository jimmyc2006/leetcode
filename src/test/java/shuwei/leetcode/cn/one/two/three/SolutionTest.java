package shuwei.leetcode.cn.one.two.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.maxProfit(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(6, s.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        Assert.assertEquals(0, s.maxProfit(new int[]{7, 6, 4, 3, 1}));
        Assert.assertEquals(0, s.maxProfit(new int[]{1}));
    }
}
