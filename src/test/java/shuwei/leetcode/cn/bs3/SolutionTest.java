package shuwei.leetcode.cn.bs3;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(18, s.longestSubarray(new int[]{1, 1, 1, 1, 1, 1, 0,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1,
            1, 1, 0, 1, 1, 1, 1, 1}));
    Assert.assertEquals(3, s.longestSubarray(new int[]{1, 1, 0, 1}));
    Assert.assertEquals(5, s.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
    Assert.assertEquals(2, s.longestSubarray(new int[]{1, 1, 1}));

    Assert.assertEquals(4, s.longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1}));
    Assert.assertEquals(0, s.longestSubarray(new int[]{0, 0, 0}));
  }
}
