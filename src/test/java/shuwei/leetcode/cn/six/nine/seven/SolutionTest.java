package shuwei.leetcode.cn.six.nine.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    Assert.assertEquals(6, s.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    Assert.assertEquals(1, s.findShortestSubArray(new int[]{1}));
  }
}
