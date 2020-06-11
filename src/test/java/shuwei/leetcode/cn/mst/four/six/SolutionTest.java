package shuwei.leetcode.cn.mst.four.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5,s.translateNum(12258));
        Assert.assertEquals(2, s.translateNum(18580));
        Assert.assertEquals(1, s.translateNum(506));
        Assert.assertEquals(1, s.translateNum(0));
    }
}
