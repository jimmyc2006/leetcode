package shuwei.leetcode.cn.one.zero.three.zero;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    int[][] ints = s.allCellsDistOrder(1, 2, 0, 0);
    for (int[] ele : ints) {
      System.out.println(Arrays.toString(ele));
    }
  }

  @Test
  public void test1() {
    Solution s = new Solution();
    int[][] ints = s.allCellsDistOrder(2, 2, 0, 1);
    for (int[] ele : ints) {
      System.out.println(Arrays.toString(ele));
    }
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    int[][] ints = s.allCellsDistOrder(2, 3, 1, 2);
    for (int[] ele : ints) {
      System.out.println(Arrays.toString(ele));
    }
  }
}
