package shuwei.leetcode.cn.nine.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    Assert.assertEquals(false, s.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    Assert.assertEquals(false, s.isInterleave("a", "b", "a"));
  }
}
