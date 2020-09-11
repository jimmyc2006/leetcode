package shuwei.leetcode.cn.two.one.six;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    List<List<Integer>> lists = s.combinationSum3(3, 15);
    for (List<Integer> ele : lists) {
      System.out.println(ele);
    }
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    List<List<Integer>> lists = s.combinationSum3(3, 9);
    for (List<Integer> ele : lists) {
      System.out.println(ele);
    }
  }

}
