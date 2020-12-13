package shuwei.leetcode.cn.two.one.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.containsDuplicate(new int[]{1, 2, 3, 1}));
        Assert.assertEquals(false, s.containsDuplicate(new int[]{1,2,3,4}));
        Assert.assertEquals(true, s.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
