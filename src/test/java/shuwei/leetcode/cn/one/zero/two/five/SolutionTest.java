package shuwei.leetcode.cn.one.zero.two.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(false, s.divisorGame(13));
        Assert.assertEquals(true, s.divisorGame(2));
        Assert.assertEquals(false, s.divisorGame(3));
        Assert.assertEquals(true, s.divisorGame(6));
        Assert.assertEquals(false, s.divisorGame(1));
    }
}
