package shuwei.leetcode.cn.one.zero.one.eight;

import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(s.prefixesDivBy5(new int[]{0, 1, 1}));
    System.out.println(s.prefixesDivBy5(new int[]{1, 1, 1}));
    System.out.println(s.prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1}));
    System.out.println(s.prefixesDivBy5(new int[]{1, 1, 1, 0, 1}));
  }
}
