package shuwei.leetcode.cn.nine.seven.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    int[] ints = s.sortedSquares(new int[]{-4, -1, 0, 3, 10});
    Assert.assertArrayEquals(new int[]{0, 1, 9, 16, 100}, ints);
    Assert.assertArrayEquals(new int[]{4, 9, 9, 49, 121}, s.sortedSquares(new int[]{-7, -3, 2, 3, 11}));
    Assert.assertArrayEquals(new int[]{1}, s.sortedSquares(new int[]{1}));
  }

}
