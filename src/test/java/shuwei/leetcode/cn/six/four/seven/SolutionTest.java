package shuwei.leetcode.cn.six.four.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(0, s.countSubstrings(""));
    Assert.assertEquals(1, s.countSubstrings("a"));
    Assert.assertEquals(3, s.countSubstrings("abc"));
    Assert.assertEquals(6, s.countSubstrings("aaa"));
    Assert.assertEquals(15, s.countSubstrings("aaaaa"));
  }
}
