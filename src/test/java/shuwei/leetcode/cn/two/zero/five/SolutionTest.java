package shuwei.leetcode.cn.two.zero.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.isIsomorphic("egg", "add"));
    Assert.assertEquals(false, s.isIsomorphic("foo", "bar"));
    Assert.assertEquals(true, s.isIsomorphic("paper", "title"));
    Assert.assertEquals(true, s.isIsomorphic("", ""));
    Assert.assertEquals(false, s.isIsomorphic("ab", "aa"));
  }
}
