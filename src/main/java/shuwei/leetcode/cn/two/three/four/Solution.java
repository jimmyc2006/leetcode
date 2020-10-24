package shuwei.leetcode.cn.two.three.four;

import shuwei.leetcode.cn.ListNode;

public class Solution {

  public boolean isPalindrome(ListNode head) {
    ans = true;
    ListNode slow = head;
    ListNode fast = head;
    return ans && deal(slow, fast);
  }

  private boolean ans;
  private ListNode curr;

  private boolean deal(ListNode slow, ListNode fast) {
    if (curr != null) {
      if (ans && slow.val == curr.val) {
        curr = curr.next;
        return true;
      } else {
        ans = false;
        return false;
      }
    }
    if (fast == null) {
      curr = slow;
      return true;
    }
    fast = fast.next;
    if (fast == null) {
      curr = slow.next;
      return true;
    } else {
      if (!deal(slow.next, fast.next)) {
        ans = false;
        return false;
      }
      if (curr == null) {
        ans = false;
        return false;
      }
      int val = curr.val;
      curr = curr.next;
      return ans && slow.val == val;
    }
  }
}
