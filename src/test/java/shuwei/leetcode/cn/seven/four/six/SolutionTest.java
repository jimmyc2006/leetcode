package shuwei.leetcode.cn.seven.four.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(6, s.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    Assert.assertEquals(15, s.minCostClimbingStairs(new int[]{10, 15, 20}));
  }
}
