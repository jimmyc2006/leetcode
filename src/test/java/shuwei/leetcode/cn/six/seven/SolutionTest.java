package shuwei.leetcode.cn.six.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("100", s.addBinary("11", "1"));
        Assert.assertEquals("10101", s.addBinary("1010", "1011"));
    }
}
