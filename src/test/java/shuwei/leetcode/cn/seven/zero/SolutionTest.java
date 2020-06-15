package shuwei.leetcode.cn.seven.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.climbStairs(2));
    Assert.assertEquals(3, s.climbStairs(3));
  }
}
