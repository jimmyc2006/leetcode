package shuwei.leetcode.cn.one.zero.four.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(1, s.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
  }
}
