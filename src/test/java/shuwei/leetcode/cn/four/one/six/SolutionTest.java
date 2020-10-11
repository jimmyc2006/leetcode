package shuwei.leetcode.cn.four.one.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertTrue(s.canPartition(new int[]{1, 5, 11, 5}));
    Assert.assertFalse(s.canPartition(new int[]{1, 2, 3, 5}));
  }
}
