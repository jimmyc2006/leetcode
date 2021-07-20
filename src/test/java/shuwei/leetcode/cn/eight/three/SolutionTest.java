package shuwei.leetcode.cn.eight.three;

import org.junit.Test;

import shuwei.leetcode.cn.ListNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    ListNode listNode = s.deleteDuplicates(null);
    System.out.println(listNode);
  }

}
