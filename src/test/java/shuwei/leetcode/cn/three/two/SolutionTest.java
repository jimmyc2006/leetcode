package shuwei.leetcode.cn.three.two;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.longestValidParentheses("(()"));
    Assert.assertEquals(4, s.longestValidParentheses(")()())"));
    Assert.assertEquals(6, s.longestValidParentheses("()()())()"));
    Assert.assertEquals(8, s.longestValidParentheses("()()())(((()))))()"));
  }
}
