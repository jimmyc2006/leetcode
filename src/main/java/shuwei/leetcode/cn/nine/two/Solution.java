package shuwei.leetcode.cn.nine.two;

import shuwei.leetcode.cn.ListNode;

public class Solution {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode[] ln = new ListNode[500];
    int index = 0;
    int count = 0;
    ListNode node = head;
    ListNode pre = null;
    ListNode tail = null;
    while (node != null && count < right) {
      count++;
      if (count >= left) {
        ln[index++] = node;
      } else {
        pre = node;
      }
      node = node.next;
    }
    tail = node;
    for (int i = index - 1; i > 0; i--) {
      ln[i].next= ln[i - 1];
    }
    if (index > 0) {
      ln[0].next = tail;
    }
    if (pre != null) {
      pre.next = ln[index - 1];
      return head;
    } else {
      return ln[index - 1];
    }
  }
}
