package shuwei.leetcode.cn.one.seven.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(7, s.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
    Assert.assertEquals(1, s.calculateMinimumHP(new int[][]{{100}}));
  }
}
