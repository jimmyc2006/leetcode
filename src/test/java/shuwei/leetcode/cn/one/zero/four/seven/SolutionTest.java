package shuwei.leetcode.cn.one.zero.four.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals("ca", s.removeDuplicates("abbaca"));
    Assert.assertEquals("a", s.removeDuplicates("a"));
  }
}
