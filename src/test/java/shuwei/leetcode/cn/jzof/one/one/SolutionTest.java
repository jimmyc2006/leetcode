package shuwei.leetcode.cn.jzof.one.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(-10, s.minArray(new int[]{10, 10, 10, -10, -10, -10, -10, -9, -9, -9, -9, -9, -9, -9, -8, -8, -8, -8, -8, -8, -8, -8, -7, -7, -7, -7, -6, -6, -6, -5, -5, -5, -4, -4, -4, -4, -3, -3, -2, -2, -2, -2, -2, -2, -2, -2, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 10, 10}));
    Assert.assertEquals(1, s.minArray(new int[]{1, 3}));
    Assert.assertEquals(1, s.minArray(new int[]{1, 3, 5}));
    Assert.assertEquals(0, s.minArray(new int[]{2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2}));
    Assert.assertEquals(0, s.minArray(new int[]{2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2}));
    Assert.assertEquals(1, s.minArray(new int[]{3, 4, 5, 1, 2}));
    Assert.assertEquals(0, s.minArray(new int[]{2, 2, 2, 0, 1}));
  }
}
