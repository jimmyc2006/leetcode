package shuwei.leetcode.cn.six.two;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(28, s.uniquePaths(3, 7));
    Assert.assertEquals(3, s.uniquePaths(3,2));
    Assert.assertEquals(28, s.uniquePaths(7, 3));
    Assert.assertEquals(6, s.uniquePaths(3, 3));
  }
}
