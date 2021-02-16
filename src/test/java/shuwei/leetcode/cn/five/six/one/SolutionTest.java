package shuwei.leetcode.cn.five.six.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.arrayPairSum(new int[]{5}));
        Assert.assertEquals(4, s.arrayPairSum(new int[]{1, 4, 2, 3}));
        Assert.assertEquals(9, s.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
    }

}
