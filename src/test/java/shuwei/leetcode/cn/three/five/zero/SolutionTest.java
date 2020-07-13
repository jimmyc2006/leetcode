package shuwei.leetcode.cn.three.five.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[]{2,2}, s.intersect(new int[]{1,2,2,1}, new int[]{2,2}));
    }
}
