package shuwei.leetcode.cn.five.six.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertArrayEquals(new int[][]{{1, 2, 3, 4}}, s.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4));
    Assert.assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, s.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4));
  }
}
