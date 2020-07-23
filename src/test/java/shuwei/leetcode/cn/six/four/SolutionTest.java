package shuwei.leetcode.cn.six.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(7, s.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    Assert.assertEquals(3, s.minPathSum(new int[][]{{3}}));
    Assert.assertEquals(0, s.minPathSum(new int[][]{{}}));
  }
}
