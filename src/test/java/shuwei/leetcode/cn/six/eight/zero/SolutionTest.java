package shuwei.leetcode.cn.six.eight.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.validPalindrome("aba"));
    Assert.assertEquals(true, s.validPalindrome("abca"));
    Assert.assertEquals(false, s.validPalindrome("abc"));
  }
}
