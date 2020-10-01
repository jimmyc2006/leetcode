package shuwei.leetcode.cn.five.two.nine;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    char[][] res = s.updateBoard(new char[][]{
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'M', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'}}, new int[]{3,0});
    for (char[] ele : res) {
      System.out.println(Arrays.toString(ele));
    }
    System.out.println("----------");
    char[][] res2 = s.updateBoard(new char[][]{
            {'E','E','E','E','E','E','E','E'},
            {'E','E','E','E','E','E','E','M'},
            {'E','E','M','E','E','E','E','E'},
            {'M','E','E','E','E','E','E','E'},
            {'E','E','E','E','E','E','E','E'},
            {'E','E','E','E','E','E','E','E'},
            {'E','E','E','E','E','E','E','E'},
            {'E','E','M','M','E','E','E','E'}}, new int[]{0,0});
    for (char[] ele : res2) {
      System.out.println(Arrays.toString(ele));
    }
  }
}
