package shuwei.leetcode.cn.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(321, s.reverse(123));
    Assert.assertEquals(-321, s.reverse(-123));
    Assert.assertEquals(21, s.reverse(120));
  }
}
