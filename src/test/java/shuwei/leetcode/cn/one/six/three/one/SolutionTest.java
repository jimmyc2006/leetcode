package shuwei.leetcode.cn.one.six.three.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(5, s.minimumEffortPath(new int[][]{{4, 3, 4, 10, 5, 5, 9, 2}, {10, 8, 2, 10, 9, 7, 5, 6}, {5, 8, 10, 10, 10, 7, 4, 2}, {5, 1, 3, 1, 1, 3, 1, 9}, {6, 4, 10, 6, 10, 9, 4, 6}}));
    Assert.assertEquals(2, s.minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
    Assert.assertEquals(1, s.minimumEffortPath(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));
    Assert.assertEquals(0, s.minimumEffortPath(new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}}));
  }
}
