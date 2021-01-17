package shuwei.leetcode.cn.nine.four.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(19, s.removeStones(new int[][]{{5, 9}, {9, 0}, {0, 0}, {7, 0}, {4, 3},
            {8, 5}, {5, 8}, {1, 1}, {0, 6}, {7, 5}, {1, 6}, {1, 9}, {9, 4}, {2, 8}, {1, 3}, {4, 2}, {2, 5}, {4, 1}, {0, 2}, {6, 5}}));
    Assert.assertEquals(5, s.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
    Assert.assertEquals(3, s.removeStones(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}));
    Assert.assertEquals(0, s.removeStones(new int[][]{{0, 0}}));
  }
}
