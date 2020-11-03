package shuwei.leetcode.cn.nine.four.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertFalse(s.validMountainArray(new int[]{2, 1}));
    Assert.assertFalse(s.validMountainArray(new int[]{3, 5, 5}));
    Assert.assertTrue(s.validMountainArray(new int[]{0, 3, 2, 1}));
  }
}
