package shuwei.leetcode.cn.three.three.six;

import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(s.palindromePairs(new String[]{"a", "abc", "aba", ""}));
    System.out.println(s.palindromePairs(new String[]{"a", ""}));
    System.out.println(s.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
    System.out.println(s.palindromePairs(new String[]{"bat", "tab", "cat"}));
    System.out.println(s.palindromePairs(new String[]{}));
  }
}
