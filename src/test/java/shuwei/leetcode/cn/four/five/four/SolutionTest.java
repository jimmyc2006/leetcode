package shuwei.leetcode.cn.four.five.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(76, s.fourSumCount(new int[]{1, 1, -1, -1}, new int[]{-1, -1, 1, 1}, new int[]{1, -1, 0, -1}, new int[]{1, 1, -1, 1}));
    Assert.assertEquals(17, s.fourSumCount(new int[]{0, 1, -1}, new int[]{-1, 1, 0}, new int[]{0, 0, 1}, new int[]{-1, 1, 1}));
    Assert.assertEquals(2, s.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
  }
}
