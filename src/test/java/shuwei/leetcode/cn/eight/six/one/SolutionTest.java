package shuwei.leetcode.cn.eight.six.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(39, s.matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
    Assert.assertEquals(1, s.matrixScore(new int[][]{{1}}));
  }
}
