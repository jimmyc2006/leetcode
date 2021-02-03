package shuwei.leetcode.cn.four.eight.zero;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.medianSlidingWindow(new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2}, 3)));
    System.out.println(Arrays.toString(s.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
  }
}
