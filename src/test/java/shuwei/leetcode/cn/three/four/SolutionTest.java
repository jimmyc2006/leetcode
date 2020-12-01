package shuwei.leetcode.cn.three.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertArrayEquals(new int[]{3, 4}, s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    Assert.assertArrayEquals(new int[]{-1, -1}, s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
    Assert.assertArrayEquals(new int[]{-1, -1}, s.searchRange(new int[]{}, 0));
  }
}
