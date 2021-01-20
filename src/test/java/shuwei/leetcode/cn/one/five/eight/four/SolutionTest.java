package shuwei.leetcode.cn.one.five.eight.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(20, s.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
    Assert.assertEquals(18, s.minCostConnectPoints(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}));
    Assert.assertEquals(4, s.minCostConnectPoints(new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}}));
    Assert.assertEquals(4000000, s.minCostConnectPoints(new int[][]{{-1000000, -1000000}, {1000000, 1000000}}));
    Assert.assertEquals(0, s.minCostConnectPoints(new int[][]{{1000000, 1000000}}));
  }
}
