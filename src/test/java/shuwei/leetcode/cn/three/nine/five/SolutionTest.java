package shuwei.leetcode.cn.three.nine.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(0, s.longestSubstring("ababacb", 3));
    Assert.assertEquals(3, s.longestSubstring("aaabb", 3));
    Assert.assertEquals(5, s.longestSubstring("ababbc", 2));
  }
}
