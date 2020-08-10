package shuwei.leetcode.cn.six.nine.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.countBinarySubstrings("10101"));
        Assert.assertEquals(6, s.countBinarySubstrings("00110011"));
    }
}
