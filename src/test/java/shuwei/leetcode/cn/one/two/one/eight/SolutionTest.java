package shuwei.leetcode.cn.one.two.one.eight;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals('e', s.findTheDifference("abcd", "abcde"));
        Assert.assertEquals('y', s.findTheDifference("", "y"));
        Assert.assertEquals('a', s.findTheDifference("ae", "aea"));
    }
}
