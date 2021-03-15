package shuwei.leetcode.cn.five.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertArrayEquals(new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5},
            s.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).stream().mapToInt(t -> t).toArray());
    Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7},
            s.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}).stream().mapToInt(t -> t).toArray());
    Assert.assertArrayEquals(new int[]{1},
            s.spiralOrder(new int[][]{{1}}).stream().mapToInt(t -> t).toArray());
  }
}
