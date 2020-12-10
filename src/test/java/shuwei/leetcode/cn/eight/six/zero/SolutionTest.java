package shuwei.leetcode.cn.eight.six.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    Assert.assertEquals(true, s.lemonadeChange(new int[]{5, 5, 10}));
    Assert.assertEquals(false, s.lemonadeChange(new int[]{10, 10}));
    Assert.assertEquals(false, s.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    Assert.assertEquals(true, s.lemonadeChange(new int[]{}));
  }
}
