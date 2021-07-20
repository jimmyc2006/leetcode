package shuwei.leetcode.cn.seven.three;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    int[][] data = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    s.setZeroes(data);
    for (int i = 0; i < data.length; i++) {
      System.out.println(Arrays.toString(data[i]));
    }
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    int[][] data = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    s.setZeroes(data);
    for (int i = 0; i < data.length; i++) {
      System.out.println(Arrays.toString(data[i]));
    }
  }

  @Test
  public void test3() {
    Solution s = new Solution();
    int[][] data = new int[][]{{0}};
    s.setZeroes(data);
    for (int i = 0; i < data.length; i++) {
      System.out.println(Arrays.toString(data[i]));
    }
  }
}
