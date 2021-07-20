package shuwei.leetcode.cn.seven.six.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
    Assert.assertEquals(false, s.isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
  }
}
