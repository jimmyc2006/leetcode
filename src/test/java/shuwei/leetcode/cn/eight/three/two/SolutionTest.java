package shuwei.leetcode.cn.eight.three.two;

import org.junit.Test;

import shuwei.leetcode.cn.TestUtil;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    TestUtil.assertArraysEquals(new int[][]{{0}}, s.flipAndInvertImage(new int[][]{{1}}));
    TestUtil.assertArraysEquals(new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 1, 1}}, s.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}));
    TestUtil.assertArraysEquals(new int[][]{{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}},
            s.flipAndInvertImage(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}}));
  }
}
