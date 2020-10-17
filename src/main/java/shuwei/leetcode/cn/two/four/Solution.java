package shuwei.leetcode.cn.two.four;

import shuwei.leetcode.cn.ListNode;

public class Solution {

  public ListNode swapPairs(ListNode head) {
    ListNode left = head;
    ListNode curr = head;
    if (head == null || head.next == null) {
      return head;
    } else {
      head = head.next;
    }
    while (curr != null) {
      if (curr.next == null) {
        break;
      } else {
        left.next = curr.next;
      }
      left = curr;
      ListNode right = curr.next;
      curr = right.next;
      right.next = left;
      left.next = curr;
    }
    return head;
  }

}
