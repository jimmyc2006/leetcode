package shuwei.leetcode.cn.five.six;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    int[][] merge = s.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    for (int[] ele : merge) {
      System.out.println(Arrays.toString(ele));
    }
    System.out.println("--------");
    int[][] merge2 = s.merge(new int[][]{{1, 4}, {4, 5}});
    for (int[] ele : merge2) {
      System.out.println(Arrays.toString(ele));
    }
  }
}
