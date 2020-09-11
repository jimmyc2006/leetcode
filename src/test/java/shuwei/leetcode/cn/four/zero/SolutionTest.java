package shuwei.leetcode.cn.four.zero;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    List<List<Integer>> lists = s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    for (List<Integer> ele : lists) {
      System.out.println(ele);
    }
  }

}
