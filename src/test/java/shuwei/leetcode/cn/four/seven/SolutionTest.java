package shuwei.leetcode.cn.four.seven;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    List<List<Integer>> lists = s.permuteUnique(new int[]{1, 1, 2});
    for (List<Integer> ele : lists) {
      System.out.println(ele);
    }
  }
}
