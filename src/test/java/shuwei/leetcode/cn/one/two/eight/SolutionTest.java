package shuwei.leetcode.cn.one.two.eight;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(4, s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    Assert.assertEquals(1, s.longestConsecutive(new int[]{0}));
    Assert.assertEquals(3, s.longestConsecutive(new int[]{1, 2, 0, 1}));
  }
}
