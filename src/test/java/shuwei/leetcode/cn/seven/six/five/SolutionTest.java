package shuwei.leetcode.cn.seven.six.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.minSwapsCouples(new int[]{0, 2, 1, 3}));
        Assert.assertEquals(0, s.minSwapsCouples(new int[]{3, 2, 0, 1}));
    }
}
