package shuwei.leetcode.cn.nine.seven.eight;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(1, s.maxTurbulenceSize(new int[]{2, 2}));
    Assert.assertEquals(8, s.maxTurbulenceSize(new int[]{9, 4, 2, 10, 1, 8, 2, 7, 3}));
    Assert.assertEquals(5, s.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
    Assert.assertEquals(2, s.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
    Assert.assertEquals(1, s.maxTurbulenceSize(new int[]{100}));
    Assert.assertEquals(4, s.maxTurbulenceSize(new int[]{4, 3, 12, 5}));
  }
}
