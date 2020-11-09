package shuwei.leetcode.cn.nine.seven.three;

import org.junit.Test;

import java.util.Arrays;

public class Solution1109Test {

  @Test
  public void test() {
    Solution1109 s = new Solution1109();
    int[][] ints = s.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
    for (int[] ele : ints) {
      System.out.println(Arrays.toString(ele));
    }
    int[][] ints2 = s.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
    for (int[] ele : ints2) {
      System.out.println(Arrays.toString(ele));
    }
  }
}
