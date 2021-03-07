package shuwei.leetcode.cn.five.zero.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertArrayEquals(new int[]{}, s.nextGreaterElements(new int[]{}));
    Assert.assertArrayEquals(new int[]{-1, 5, 5, 5, 5}, s.nextGreaterElements(new int[]{5, 4, 3, 2, 1}));
    Assert.assertArrayEquals(new int[]{2, 3, -1, 3, 2}, s.nextGreaterElements(new int[]{1, 2, 3, 2, 1}));
    Assert.assertArrayEquals(new int[]{2, -1, 2}, s.nextGreaterElements(new int[]{1, 2, 1}));
    Assert.assertArrayEquals(new int[]{-1}, s.nextGreaterElements(new int[]{2}));
  }
}
