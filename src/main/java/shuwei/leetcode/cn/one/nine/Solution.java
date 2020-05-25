package shuwei.leetcode.cn.one.nine;

import java.util.ArrayList;

public class Solution {
  // 1ms 38%
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode curr = head;
    ArrayList<ListNode> al = new ArrayList<>();
    while (curr != null) {
      al.add(curr);
      curr = curr.next;
    }
    int size = al.size();
    if (n == size) {
      return head.next;
    } else {
      if ((size - n + 1) < size) {
        al.get(size - n - 1).next = al.get(size - n + 1);
      } else {
        al.get(size - n - 1).next = null;
      }
      return head;
    }
  }
}
