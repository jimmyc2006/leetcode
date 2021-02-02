package shuwei.leetcode.cn.eight.eight.eight;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
    System.out.println(Arrays.toString(s.fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
    System.out.println(Arrays.toString(s.fairCandySwap(new int[]{2}, new int[]{1, 3})));
    System.out.println(Arrays.toString(s.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
  }
}
