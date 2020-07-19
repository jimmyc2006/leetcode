package shuwei.leetcode.cn.three.one.two;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(167, s.maxCoins(new int[]{3, 1, 5, 8}));
  }
}
