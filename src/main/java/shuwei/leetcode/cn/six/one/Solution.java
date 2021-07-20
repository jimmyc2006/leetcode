package shuwei.leetcode.cn.six.one;

import shuwei.leetcode.cn.ListNode;

public class Solution {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    int count = 0;
    ListNode curr = head;
    while (curr != null) {
      count++;
      curr = curr.next;
    }
    if (k % count == 0) {
      return head;
    }
    k = count - (k % count);
    if (k == 0) {
      return head;
    }
    ListNode root;
    curr = head;
    count = 0;
    while (count < k - 1) {
      count++;
      curr = curr.next;
    }
    root = curr.next;
    curr .next = null;
    curr = root;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = head;
    return root;
  }
}
