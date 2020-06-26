package shuwei.leetcode.cn.one.nine;

import org.junit.Test;

import shuwei.leetcode.cn.ListNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    ListNode ln = this.gen1();
    s.removeNthFromEnd(ln, 2);
    while (ln != null) {
      System.out.print(ln.val + " ");
      ln = ln.next;
    }
  }
  
  private ListNode gen1() {
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    root.next.next = new ListNode(3);
    root.next.next.next = new ListNode(4);
    root.next.next.next.next = new ListNode(5);
    return root;
  }
}
