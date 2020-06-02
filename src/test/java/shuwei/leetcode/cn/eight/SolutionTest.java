package shuwei.leetcode.cn.eight;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(42, s.myAtoi("42"));
    Assert.assertEquals(-42, s.myAtoi("    -42"));
    Assert.assertEquals(0, s.myAtoi(""));
    Assert.assertEquals(1, s.myAtoi(" +1"));
  }
}
