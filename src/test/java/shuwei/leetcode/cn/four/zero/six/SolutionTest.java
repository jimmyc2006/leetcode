package shuwei.leetcode.cn.four.zero.six;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    int[][] res = s.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    for (int[] ele : res) {
      System.out.println(Arrays.toString(ele));
    }
  }

  @Test
  public void test1() {
    Solution s = new Solution();
    int[][] res = s.reconstructQueue(new int[][]{{4, 0}});
    for (int[] ele : res) {
      System.out.println(Arrays.toString(ele));
    }
  }
}
