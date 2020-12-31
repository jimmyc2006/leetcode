package shuwei.leetcode.cn.four.three.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(1, s.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    Assert.assertEquals(2, s.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
    Assert.assertEquals(0, s.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
  }
}
