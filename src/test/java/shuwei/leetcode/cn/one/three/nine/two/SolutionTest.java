package shuwei.leetcode.cn.one.three.nine.two;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.isSubsequence("abc", "ahbgdc"));
    Assert.assertEquals(false, s.isSubsequence("axc", "ahbgdc"));
    Assert.assertEquals(true, s.isSubsequence("", "ahbgdc"));
  }
}
