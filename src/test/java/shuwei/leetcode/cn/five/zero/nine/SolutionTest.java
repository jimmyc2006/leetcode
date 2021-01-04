package shuwei.leetcode.cn.five.zero.nine;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.fib(2));
        Assert.assertEquals(2, s.fib(3));
        Assert.assertEquals(3, s.fib(4));
    }
}
