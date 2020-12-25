package shuwei.leetcode.cn.four.five.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(1, s.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    Assert.assertEquals(2, s.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
  }
}
