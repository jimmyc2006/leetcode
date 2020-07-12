package shuwei.leetcode.cn.three.zero.nine;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.maxProfit(new int[]{1, 2, 3, 0, 2}));
  }
}
