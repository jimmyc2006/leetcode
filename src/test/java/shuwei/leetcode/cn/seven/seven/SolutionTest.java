package shuwei.leetcode.cn.seven.seven;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    List<List<Integer>> combine = s.combine(4, 2);
    for (List<Integer> ele : combine) {
      System.out.println(ele);
    }
//    System.out.println("------");
//    combine = s.combine(1, 1);
//    for (List<Integer> ele : combine) {
//      System.out.println(ele);
//    }
  }
}
