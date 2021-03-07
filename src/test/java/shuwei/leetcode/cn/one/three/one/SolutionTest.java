package shuwei.leetcode.cn.one.three.one;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    List<List<String>> aab = s.partition("aab");
    for (List<String> ele : aab) {
      System.out.println(ele);
    }
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    List<List<String>> aab = s.partition("a");
    for (List<String> ele : aab) {
      System.out.println(ele);
    }
  }
}
