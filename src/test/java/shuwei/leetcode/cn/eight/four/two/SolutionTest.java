package shuwei.leetcode.cn.eight.four.two;

import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(s.splitIntoFibonacci("1102147483647214748364221474836411111"));
    System.out.println(s.splitIntoFibonacci("123456579"));
    System.out.println(s.splitIntoFibonacci("11235813"));
    System.out.println(s.splitIntoFibonacci("112358130"));
    System.out.println(s.splitIntoFibonacci("0123"));
    System.out.println(s.splitIntoFibonacci("1101111"));
  }
}
