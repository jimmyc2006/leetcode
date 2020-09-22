package shuwei.leetcode.cn.seven.eight;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    List<List<Integer>> subsets = s.subsets(new int[]{1, 2, 3});
    for (List<Integer> ele : subsets) {
      System.out.println(ele);
    }

    System.out.println("------------");
    List<List<Integer>> subsets2 = s.subsets(new int[]{});
    for (List<Integer> ele : subsets2) {
      System.out.println(ele);
    }
  }
}
