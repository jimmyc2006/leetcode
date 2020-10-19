package shuwei.leetcode.cn.eight.four.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertTrue(s.backspaceCompare("ab#c", "ad#c"));
    Assert.assertTrue(s.backspaceCompare("ab##", "c#d#"));
    Assert.assertTrue(s.backspaceCompare("a##c", "#a#c"));
    Assert.assertFalse(s.backspaceCompare("a#c", "b"));
  }

}
