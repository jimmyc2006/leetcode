package shuwei.leetcode.cn.one.two.zero.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertTrue(s.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
    Assert.assertTrue(s.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    Assert.assertFalse(s.uniqueOccurrences(new int[]{1, 2}));
  }
}
