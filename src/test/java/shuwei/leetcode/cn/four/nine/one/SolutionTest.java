package shuwei.leetcode.cn.four.nine.one;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
//    List<List<Integer>> subsequences = s.findSubsequences(new int[]{4, 6, 7, 7});
//    for (List<Integer> ele : subsequences) {
//      System.out.println(ele);
//    }
//    List<List<Integer>> subsequences2 = s.findSubsequences(new int[]{4, 6});
//    for (List<Integer> ele : subsequences2) {
//      System.out.println(ele);
//    }
    List<List<Integer>> subsequences2 = s.findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1});
    for (List<Integer> ele : subsequences2) {
      System.out.println(ele);
    }
  }
}
