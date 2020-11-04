package shuwei.leetcode.cn.five.seven;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(Arrays.deepToString(s.insert(new int[][]{{1, 5}}, new int[]{2, 3})));
    System.out.println(Arrays.deepToString(s.insert(new int[][]{{4, 5}}, new int[]{1, 3})));
    System.out.println(Arrays.deepToString(s.insert(new int[][]{{1, 5}}, new int[]{6, 8})));
    System.out.println(Arrays.deepToString(s.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    System.out.println(Arrays.deepToString(s.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
  }
}
