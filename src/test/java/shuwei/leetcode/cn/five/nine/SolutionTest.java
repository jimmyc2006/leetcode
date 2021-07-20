package shuwei.leetcode.cn.five.nine;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    int[][] ints = s.generateMatrix(3);
    for (int[] anInt : ints) {
      System.out.println(Arrays.toString(anInt));
    }
    ints = s.generateMatrix(1);
    for (int[] anInt : ints) {
      System.out.println(Arrays.toString(anInt));
    }
  }
}
