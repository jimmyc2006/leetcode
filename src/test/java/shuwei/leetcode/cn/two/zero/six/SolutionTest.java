package shuwei.leetcode.cn.two.zero.six;

import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    root.next.next = new ListNode(3);
    root.next.next.next = new ListNode(4);
    root.next.next.next.next = new ListNode(5);
    root = s.reverseList(root);
    while (root != null) {
      System.out.println(root.val);
      root = root.next;
    }
  }
}
