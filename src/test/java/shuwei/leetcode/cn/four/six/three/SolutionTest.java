package shuwei.leetcode.cn.four.six.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(0, s.islandPerimeter(new int[][]{}));
    Assert.assertEquals(4, s.islandPerimeter(new int[][]{{1}}));
    Assert.assertEquals(16, s.islandPerimeter(new int[][]{{0,1,0,0},
            {1,1,1,0},
            {0,1,0,0},
            {1,1,0,0}}));
  }
}
