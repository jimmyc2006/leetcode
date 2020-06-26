package shuwei.leetcode.cn.two.zero.six;

import shuwei.leetcode.cn.ListNode;

public class Solution {
  // 这个是速度非常快的
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode prev = head;
    ListNode tmp = prev.next;
    prev.next = null;
    while (tmp != null) {
      ListNode next = tmp.next;
      tmp.next = prev;
      prev = tmp;
      tmp = next;
    }
    return prev;
  }
}
