package shuwei.leetcode.cn.two.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
      Solution s = new Solution();
        Assert.assertEquals(true, s.isValid("{}[]()"));
        Assert.assertEquals(false, s.isValid("(]"));
        Assert.assertEquals(true, s.isValid("{[]}"));
    }
}
