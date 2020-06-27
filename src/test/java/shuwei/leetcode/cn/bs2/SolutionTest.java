package shuwei.leetcode.cn.bs2;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.kthFactor(12, 3));
    Assert.assertEquals(7, s.kthFactor(7, 2));
    Assert.assertEquals(-1, s.kthFactor(4, 4));
    Assert.assertEquals(1, s.kthFactor(1, 1));
    Assert.assertEquals(4, s.kthFactor(1000, 3));
  }
}
