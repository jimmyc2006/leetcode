package shuwei.leetcode.cn.one.four.three;

import java.util.ArrayList;
import java.util.List;

import shuwei.leetcode.cn.ListNode;

public class Solution {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    List<ListNode> list = new ArrayList<>();
    while (head != null) {
      list.add(head);
      head = head.next;
    }
    head = list.get(0);
    boolean last = true;
    for (int i = 1, j = list.size() - 1; i <= j;) {
      if (last) {
        head.next = list.get(j);
        j--;
      } else {
        head.next = list.get(i);
        i++;
      }
      head = head.next;
      last = !last;
    }
    head.next = null;
  }

}
