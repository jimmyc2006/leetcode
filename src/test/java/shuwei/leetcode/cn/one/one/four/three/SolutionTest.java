package shuwei.leetcode.cn.one.one.four.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.longestCommonSubsequence("abcde", "ace"));
    Assert.assertEquals(3, s.longestCommonSubsequence("acbd", "abedc"));
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    System.out.print(s.longestCommonSubsequence("bl", "yby"));
  }
}
