package shuwei.leetcode.cn.mst.two.one;

import java.util.HashSet;
import java.util.Set;

import shuwei.leetcode.cn.ListNode;

public class Solution {
  public ListNode removeDuplicateNodes(ListNode head) {
    if (head == null) {
      return head;
    }
    Set<Integer> nums = new HashSet<>();
    nums.add(head.val);
    ListNode cur = head, last = head;
    cur = cur.next;
    while (cur != null) {
      if (nums.add(cur.val)) {
        last.next = cur;
        last = cur;
      }
      cur = cur.next;
    }
    last.next = null;
    return head;
  }
}
