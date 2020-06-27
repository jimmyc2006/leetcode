package shuwei.leetcode.cn.four.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.firstMissingPositive(new int[]{2, 1}));
    Assert.assertEquals(1, s.firstMissingPositive(new int[]{-1}));
    Assert.assertEquals(2, s.firstMissingPositive(new int[]{1}));
    Assert.assertEquals(1, s.firstMissingPositive(new int[]{2}));
    Assert.assertEquals(3, s.firstMissingPositive(new int[]{1, 2, 0}));
    Assert.assertEquals(2, s.firstMissingPositive(new int[]{3, 4, -1, 1}));
    Assert.assertEquals(1, s.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
  }
}
