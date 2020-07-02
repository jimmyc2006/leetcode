package shuwei.leetcode.cn.three.seven.eight;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(13, s.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    Assert.assertEquals(2, s.kthSmallest(new int[][]{{1, 2}, {1, 3}}, 3));
  }
}
