package shuwei.leetcode.cn.five.four.two;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    int[][] ints = s.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    for (int[] ele : ints) {
      System.out.println(Arrays.toString(ele));
    }
    System.out.println("---------");
    int[][] ints2 = s.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
    for (int[] ele : ints2) {
      System.out.println(Arrays.toString(ele));
    }
    System.out.println("---------");
    int[][] ints3 = s.updateMatrix(new int[][]{{0, 1, 1}});
    for (int[] ele : ints3) {
      System.out.println(Arrays.toString(ele));
    }
    System.out.println("---------");
    int[][] ints4 = s.updateMatrix(new int[][]{{0}, {1}, {1}});
    for (int[] ele : ints4) {
      System.out.println(Arrays.toString(ele));
    }
  }
}
