package shuwei.leetcode.cn.two.zero.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.canFinish(2, new int[][]{{1, 0}}));
    Assert.assertEquals(false, s.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    Assert.assertEquals(true, s.canFinish(2, new int[][]{{}}));
  }
}
