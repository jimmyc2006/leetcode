package shuwei.leetcode.cn.one.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(false, s.isMatch("ab", ".*c"));
    Assert.assertEquals(true, s.isMatch("abbabaaaaaaacaa", "a*.*b.a.*c*b*a*c*"));
    Assert.assertEquals(true, s.isMatch("aaa", "ab*a*c*a"));
    Assert.assertEquals(false, s.isMatch("aa", "a"));
    Assert.assertEquals(true, s.isMatch("aa", "a*"));
    Assert.assertEquals(true, s.isMatch("ab", ".*"));
    Assert.assertEquals(false, s.isMatch("mississippi", "mis*is*p*."));
    Assert.assertEquals(true, s.isMatch("", "a*"));
    Assert.assertEquals(true, s.isMatch("aab", "c*a*b"));
    Assert.assertEquals(false, s.isMatch("aaa", "aaaa"));
    Assert.assertEquals(true, s.isMatch("aaa", "a*a"));
    Assert.assertEquals(true, s.isMatch("ssissippi", "s*is*ip*."));
  }
}
