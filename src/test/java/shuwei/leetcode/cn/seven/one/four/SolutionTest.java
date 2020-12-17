package shuwei.leetcode.cn.seven.one.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(8, s.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
