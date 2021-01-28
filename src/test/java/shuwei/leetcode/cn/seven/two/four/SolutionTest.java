package shuwei.leetcode.cn.seven.two.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    Assert.assertEquals(-1, s.pivotIndex(new int[]{1, 2, 3}));
    Assert.assertEquals(0, s.pivotIndex(new int[]{2, 1, -1}));
    Assert.assertEquals(4, s.pivotIndex(new int[]{0, 0, 0, 0, 1}));
    Assert.assertEquals(-1, s.pivotIndex(new int[]{}));
    Assert.assertEquals(0, s.pivotIndex(new int[]{1}));
  }
}
