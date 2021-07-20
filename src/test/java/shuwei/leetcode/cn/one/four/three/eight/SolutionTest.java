package shuwei.leetcode.cn.one.four.three.eight;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(4, s.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
    Assert.assertEquals(5, s.longestSubarray(new int[]{1, 5, 6, 7, 8, 10, 6, 5, 6}, 4));
    Assert.assertEquals(6, s.longestSubarray(new int[]{2, 2, 2, 4, 4, 2, 5, 5, 5, 5, 5, 2}, 2));
    Assert.assertEquals(2, s.longestSubarray(new int[]{8, 2, 4, 7}, 4));
    Assert.assertEquals(3, s.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
  }
}
