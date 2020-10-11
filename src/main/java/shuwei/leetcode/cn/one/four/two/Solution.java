package shuwei.leetcode.cn.one.four.two;

import shuwei.leetcode.cn.ListNode;

public class Solution {

  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      fast = fast.next;
      if (fast == null) {
        return null;
      }
      fast = fast.next;
      slow = slow.next;
      if (slow == fast) {
        slow = head;
        while (true) {
          if (slow == fast) {
            return slow;
          }
          slow = slow.next;
          fast = fast.next;
        }
      }
    }
    return null;
  }

}
