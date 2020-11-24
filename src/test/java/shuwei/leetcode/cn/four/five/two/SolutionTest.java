package shuwei.leetcode.cn.four.five.two;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}));
    Assert.assertEquals(2, s.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    Assert.assertEquals(4, s.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
    Assert.assertEquals(2, s.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    Assert.assertEquals(1, s.findMinArrowShots(new int[][]{{1, 2}}));
    Assert.assertEquals(1, s.findMinArrowShots(new int[][]{{1, 2}, {1, 2}}));
  }
  }
