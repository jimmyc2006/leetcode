package shuwei.leetcode.cn.two.one;

public class Solution {

  // 官方的简洁版本
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  // 自己写的，冗余代码
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    }
    ListNode root = null;
    ListNode curr = null;
    // 这种代码有点冗余
    if (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        root = l1;
        l1 = l1.next;
      } else {
        root = l2;
        l2 = l2.next;
      }
    } else if (l1 != null) {
      root = l1;
      l1 = l1.next;
    } else {
      root = l2;
      l2 = l2.next;
    }
    curr = root;
    while (l1 != null || l2 != null) {
      if (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
          curr.next = l1;
          l1 = l1.next;
        } else {
          curr.next = l2;
          l2 = l2.next;
        }
      } else if (l1 != null) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }
    return root;
  }
}
