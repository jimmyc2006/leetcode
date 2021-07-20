package shuwei.leetcode.cn.five.seven.zero.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.areAlmostEqual("bank", "kanb"));
    Assert.assertEquals(false, s.areAlmostEqual("attack", "defend"));
    Assert.assertEquals(true, s.areAlmostEqual("kelb", "kelb"));
    Assert.assertEquals(false, s.areAlmostEqual("abcd", "dcba"));
  }
}
