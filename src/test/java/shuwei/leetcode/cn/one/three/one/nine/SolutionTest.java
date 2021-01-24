package shuwei.leetcode.cn.one.three.one.nine;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(1, s.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
    Assert.assertEquals(2, s.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));
    Assert.assertEquals(-1, s.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}));
    Assert.assertEquals(0, s.makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}}));
  }
}
