package shuwei.leetcode.cn.seven.seven.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test(){
        Solution s = new Solution();
        Assert.assertEquals(3, s.numJewelsInStones("aA", "aAAbbbb"));
        Assert.assertEquals(0, s.numJewelsInStones("z", "ZZ"));
        Assert.assertEquals(0, s.numJewelsInStones(null, "ZZ"));
    }
}
