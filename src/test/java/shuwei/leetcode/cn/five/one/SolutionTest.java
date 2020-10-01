package shuwei.leetcode.cn.five.one;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
  @Test
  public void test() {
    long start = System.currentTimeMillis();
    Solution s = new Solution();
    List<List<String>> lists = s.solveNQueens(8);
    System.out.println(lists.size());
    for (List<String> ele : lists) {
      System.out.println("----------");
      for (String str : ele) {
        System.out.println(str);
      }
    }
    System.out.println(System.currentTimeMillis() - start);
  }
}
