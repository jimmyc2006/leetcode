package shuwei.leetcode.cn.seven.six.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
//    Assert.assertEquals("aba", s.reorganizeString("aab"));
    Assert.assertEquals("", s.reorganizeString("aaab"));
  }
}
