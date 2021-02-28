package shuwei.leetcode.cn.five.six.nine.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(10, s.closestCost(new int[]{10}, new int[]{1}, 1));
    Assert.assertEquals(10, s.closestCost(new int[]{1, 7}, new int[]{3, 4}, 10));
    Assert.assertEquals(17, s.closestCost(new int[]{2,3}, new int[]{4,5,100}, 18));
    Assert.assertEquals(8, s.closestCost(new int[]{3,10}, new int[]{2,5}, 9));
  }
}
