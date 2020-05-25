package shuwei.leetcode.cn.two.one.zero;

import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.findOrder(2, new int[][] { { 1, 0 } })));
    System.out.println(Arrays.toString(s.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })));
  }
}
