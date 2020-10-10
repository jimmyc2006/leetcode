package shuwei.leetcode.cn.one.four.one;

import shuwei.leetcode.cn.ListNode;

public class Solution {

  /**
   * 不用set的话，就用快慢指针好了
   * @param head
   * @return
   */
  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
      if (fast == null) {
        return false;
      }
      fast = fast.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
