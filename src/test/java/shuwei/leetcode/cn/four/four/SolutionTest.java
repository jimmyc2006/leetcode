package shuwei.leetcode.cn.four.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(false, s.isMatch("aa", "a"));
    Assert.assertEquals(true, s.isMatch("aa", "*"));
    Assert.assertEquals(false, s.isMatch("cb", "?a"));
    Assert.assertEquals(true, s.isMatch("adceb", "*a*b"));
    Assert.assertEquals(false, s.isMatch("acdcb", "a*c?b"));
    Assert.assertEquals(true, s.isMatch("", ""));
    Assert.assertEquals(true, s.isMatch("", "**"));
    Assert.assertEquals(false, s.isMatch("", "*?*"));
    Assert.assertEquals(true, s.isMatch("a", "*?*"));
    Assert.assertEquals(false, s.isMatch("zacabz", "*a?b*"));
  }
}