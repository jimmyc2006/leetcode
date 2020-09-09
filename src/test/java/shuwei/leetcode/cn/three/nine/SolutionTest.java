package shuwei.leetcode.cn.three.nine;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    List<List<Integer>> lists = s.combinationSum(new int[]{2, 3, 6, 7}, 7);
    for (List<Integer> ele : lists) {
      System.out.println(ele);
    }

    System.out.println("------------");
    List<List<Integer>> lists2 = s.combinationSum(new int[]{2,3,5}, 8);
    for (List<Integer> ele : lists2) {
      System.out.println(ele);
    }
  }
}
