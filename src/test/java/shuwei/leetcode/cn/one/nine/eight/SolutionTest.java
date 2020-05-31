package shuwei.leetcode.cn.one.nine.eight;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(4, s.rob(new int[]{1, 2, 3, 1}));
    System.out.print(s.rob(new int[]{2, 7, 9, 3, 1}));
  }
}
