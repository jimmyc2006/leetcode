package shuwei.leetcode.cn.three.two.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertArrayEquals(new int[]{9, 8, 6, 5, 3}, s.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5));
  }
}
