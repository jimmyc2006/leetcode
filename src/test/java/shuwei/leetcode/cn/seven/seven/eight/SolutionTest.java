package shuwei.leetcode.cn.seven.seven.eight;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.swimInWater(new int[][]{{0, 7, 8}, {1, 2, 3}, {1, 2, 3}}));
    Assert.assertEquals(9, s.swimInWater(new int[][]{{9}}));
    Assert.assertEquals(3, s.swimInWater(new int[][]{{0, 2}, {1, 3}}));
    Assert.assertEquals(16, s.swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
  }
}
