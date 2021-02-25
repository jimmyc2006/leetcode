package shuwei.leetcode.cn.eight.six.seven;

import org.junit.Test;

import shuwei.leetcode.cn.TestUtil;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    TestUtil.assertArraysEquals(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}, s.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    TestUtil.assertArraysEquals(new int[][]{{1, 4}, {2, 5}, {3, 6}}, s.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    TestUtil.assertArraysEquals(new int[][]{{1}}, s.transpose(new int[][]{{1}}));
  }
}
