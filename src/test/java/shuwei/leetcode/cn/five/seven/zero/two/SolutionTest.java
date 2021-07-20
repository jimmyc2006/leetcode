package shuwei.leetcode.cn.five.seven.zero.two;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.findCenter(new int[][]{{1,2,},{2,3},{4,2}}));
  }
}
