package shuwei.leetcode.cn.three.four.two;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test(){
        Solution s = new Solution();
        Assert.assertEquals(s.isPowerOfFour(Integer.MAX_VALUE), false);
        Assert.assertEquals(s.isPowerOfFour(16), true);
        Assert.assertEquals(s.isPowerOfFour(5), false);
        Assert.assertEquals(s.isPowerOfFour(1), true);
    }

}
