package shuwei.leetcode.cn.eight.three;

import shuwei.leetcode.cn.ListNode;

public class Solution {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode curr = head;
    ListNode next;
    while(curr != null) {
      next = curr.next;
      if (next == null) {
        return head;
      }
      if (curr.val == next.val) {
        curr.next = next.next;
      } else {
        curr = next;
      }
    }
    return head;
  }
}
