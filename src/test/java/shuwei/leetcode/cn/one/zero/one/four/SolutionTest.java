package shuwei.leetcode.cn.one.zero.one.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test(){
        Solution to = new Solution();
        Assert.assertEquals(11, to.maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }
}
