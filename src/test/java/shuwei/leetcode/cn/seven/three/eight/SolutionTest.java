package shuwei.leetcode.cn.seven.three.eight;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1234, s.monotoneIncreasingDigits(1234));
        Assert.assertEquals(9, s.monotoneIncreasingDigits(10));
        Assert.assertEquals(299, s.monotoneIncreasingDigits(332));
    }
}
