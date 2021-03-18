package shuwei.leetcode.cn.nine.two;

import org.junit.Test;

import shuwei.leetcode.cn.ListNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    ListNode listNode = s.reverseBetween(ListNode.gen("1,2,3,4,5"), 2, 4);
    System.out.println(listNode.b2String());
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    ListNode listNode = s.reverseBetween(ListNode.gen("5"), 1, 1);
    System.out.println(listNode.b2String());
  }

  @Test
  public void test3() {
    Solution s = new Solution();
    ListNode listNode = s.reverseBetween(ListNode.gen("3, 5"), 1, 2);
    System.out.println(listNode.b2String());
  }
}
