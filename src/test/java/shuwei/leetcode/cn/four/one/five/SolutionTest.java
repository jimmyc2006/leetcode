package shuwei.leetcode.cn.four.one.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals("107", s.addStrings("98", "9"));
    Assert.assertEquals("12", s.addStrings("9", "3"));
    Assert.assertEquals("1", s.addStrings("1", ""));
    Assert.assertEquals("2", s.addStrings("1", "1"));
  }
}
