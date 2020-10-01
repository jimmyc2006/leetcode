package shuwei.leetcode.cn.two.zero.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(0, s.rangeBitwiseAnd(0, 1));
    Assert.assertEquals(4, s.rangeBitwiseAnd(5, 7));
    Assert.assertEquals(2147483647, s.rangeBitwiseAnd(2147483647, 2147483647));
    Assert.assertEquals(0, s.rangeBitwiseAnd(1, Integer.MAX_VALUE));
    Assert.assertEquals(2147483646, s.rangeBitwiseAnd(2147483646, 2147483647));
  }
}
