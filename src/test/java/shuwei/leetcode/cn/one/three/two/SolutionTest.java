package shuwei.leetcode.cn.one.three.two;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(1, s.minCut("aaabaa"));
    Assert.assertEquals(1, s.minCut("ab"));
    Assert.assertEquals(1, s.minCut("aab"));
    Assert.assertEquals(0, s.minCut("a"));
    Assert.assertEquals(3, s.minCut("cabababcbc"));
  }
}
