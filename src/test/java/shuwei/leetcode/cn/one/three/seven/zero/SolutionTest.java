package shuwei.leetcode.cn.one.three.seven.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals("abccbaabccba", s.sortString("aaaabbbbcccc"));
    Assert.assertEquals("art", s.sortString("rat"));
    Assert.assertEquals("cdelotee", s.sortString("leetcode"));
    Assert.assertEquals("ggggggg", s.sortString("ggggggg"));
    Assert.assertEquals("a", s.sortString("a"));
  }
}
