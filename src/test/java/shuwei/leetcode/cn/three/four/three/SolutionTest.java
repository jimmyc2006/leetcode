package shuwei.leetcode.cn.three.four.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(1, s.integerBreak(2));
    Assert.assertEquals(4, s.integerBreak(4));
    Assert.assertEquals(9, s.integerBreak(6));
    Assert.assertEquals(18, s.integerBreak(8));
    Assert.assertEquals(36, s.integerBreak(10));
//    Assert.assertEquals(1, s.integerBreak(2));
  }
}
