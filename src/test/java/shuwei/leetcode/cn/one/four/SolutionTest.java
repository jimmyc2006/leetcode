package shuwei.leetcode.cn.one.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("fl", s.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        Assert.assertEquals("", s.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
