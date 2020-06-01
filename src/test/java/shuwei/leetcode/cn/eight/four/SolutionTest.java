package shuwei.leetcode.cn.eight.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(10, s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    Assert.assertEquals(0, s.largestRectangleArea(new int[]{0}));
  }
}
