package shuwei.leetcode.seven.three.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    int[][] result = s.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
    Assert.assertArrayEquals(new int[]{2, 2, 2}, result[0]);
    Assert.assertArrayEquals(new int[]{2, 2, 0}, result[1]);
    Assert.assertArrayEquals(new int[]{2, 0, 1}, result[2]);
  }

}
