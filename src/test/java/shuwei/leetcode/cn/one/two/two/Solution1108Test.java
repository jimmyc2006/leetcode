package shuwei.leetcode.cn.one.two.two;

import org.junit.Assert;
import org.junit.Test;

public class Solution1108Test {

  @Test
  public void test() {
    Solution1108 s = new Solution1108();
    Assert.assertEquals(7, s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    Assert.assertEquals(4, s.maxProfit(new int[]{1, 2, 3, 4, 5}));
    Assert.assertEquals(0, s.maxProfit(new int[]{7, 6, 4, 3, 1}));
  }
}
