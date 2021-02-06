package shuwei.leetcode.cn.one.two.zero.eight;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test(){
        Solution s = new Solution();
        Assert.assertEquals(1, s.equalSubstring("abcd", "acde", 0));
        Assert.assertEquals(3, s.equalSubstring("abcd", "bcdf", 3));
        Assert.assertEquals(1, s.equalSubstring("abcd", "cdef", 3));
    }
}
