package shuwei.leetcode.cn.one.four.eight;

import shuwei.leetcode.cn.ListNode;

public class Solution {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
        if (fast != null) {
          slow = slow.next;
        }
      }
    }
    ListNode rightHead = slow.next;
    slow.next = null;
    ListNode left = sortList(head);
    ListNode right = sortList(rightHead);
    return merge(left, right);
  }

  public ListNode merge(ListNode head1, ListNode head2) {
    ListNode dummyHead = new ListNode(0);
    ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
    while (temp1 != null && temp2 != null) {
      if (temp1.val <= temp2.val) {
        temp.next = temp1;
        temp1 = temp1.next;
      } else {
        temp.next = temp2;
        temp2 = temp2.next;
      }
      temp = temp.next;
    }
    if (temp1 != null) {
      temp.next = temp1;
    } else if (temp2 != null) {
      temp.next = temp2;
    }
    return dummyHead.next;
  }

  private ListNode sort(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode head;
    if (l1.val <= l2.val) {
      head = l1;
      head.next = sort(l1.next, l2);
    } else {
      head = l2;
      head.next = sort(l1, l2.next);
    }
    return head;
  }
}
