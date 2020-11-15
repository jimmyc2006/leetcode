package shuwei.leetcode.cn.four.zero.two;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals("0", s.removeKdigits("10", 1));
    Assert.assertEquals("0", s.removeKdigits("9", 1));
    Assert.assertEquals("0", s.removeKdigits("10", 2));
    Assert.assertEquals("1219", s.removeKdigits("1432219", 3));
    Assert.assertEquals("200", s.removeKdigits("10200", 1));
  }
}
