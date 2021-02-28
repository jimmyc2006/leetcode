package shuwei.leetcode.cn.eight.nine.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.isMonotonic(new int[]{1, 2, 2, 3}));
    Assert.assertEquals(true, s.isMonotonic(new int[]{6, 5, 4, 4}));
    Assert.assertEquals(false, s.isMonotonic(new int[]{1, 3, 2}));
    Assert.assertEquals(true, s.isMonotonic(new int[]{1, 2, 4, 5}));
    Assert.assertEquals(true, s.isMonotonic(new int[]{1, 1, 1}));
    Assert.assertEquals(true, s.isMonotonic(new int[]{1, 1, 0}));
  }
}
