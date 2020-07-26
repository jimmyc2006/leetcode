package shuwei.leetcode.cn.three.two.nine;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(4, s.longestIncreasingPath(new int[][]{{9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}}));
    Assert.assertEquals(4, s.longestIncreasingPath(new int[][]{{3, 4, 5},
            {3, 2, 6},
            {2, 2, 1}}));
    Assert.assertEquals(0, s.longestIncreasingPath(new int[][]{{}}));
  }
}
