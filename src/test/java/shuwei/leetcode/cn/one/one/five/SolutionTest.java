package shuwei.leetcode.cn.one.one.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.numDistinct("ddd", "dd"));
    Assert.assertEquals(3, s.numDistinct("rabbbit", "rabbit"));
    Assert.assertEquals(5, s.numDistinct("babgbag", "bag"));
    Assert.assertEquals(1, s.numDistinct("a", "a"));
  }
}
