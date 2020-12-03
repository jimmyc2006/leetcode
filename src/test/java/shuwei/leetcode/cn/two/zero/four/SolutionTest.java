package shuwei.leetcode.cn.two.zero.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.countPrimes(10));
        Assert.assertEquals(0, s.countPrimes(0));
        Assert.assertEquals(0, s.countPrimes(1));
        Assert.assertEquals(1, s.countPrimes(3));
        Assert.assertEquals(114155, s.countPrimes(1500000));
    }
}
