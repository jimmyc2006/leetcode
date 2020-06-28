package shuwei.leetcode.cn.two.zero.nine;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
  }
}
