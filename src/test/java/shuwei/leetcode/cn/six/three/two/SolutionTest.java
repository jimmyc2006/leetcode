package shuwei.leetcode.cn.six.three.two;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.ArrayUtil;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertArrayEquals(new int[]{20, 24}, s.smallestRange(ArrayUtil.toList(new Integer[][]{{4,10,15,24,26}, {0,9,12,20}, {5,18,22,30}})));
//    Assert.assertArrayEquals(new int[]{});
  }
}
