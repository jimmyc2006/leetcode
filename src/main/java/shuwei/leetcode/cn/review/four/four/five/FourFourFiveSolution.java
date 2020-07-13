package shuwei.leetcode.cn.review.four.four.five;

import shuwei.leetcode.cn.ListNode;

public class FourFourFiveSolution {
  // 从地位加到高位
  // 先测试出长度差距，然后再计算
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    int size1 = this.culSize(l1);
    int size2 = this.culSize(l2);
    ListNode ans;
    if (size1 > size2) {
      ans = addNoHeadBefore(l1, l2, size1 - size2);
    } else {
      ans = addNoHeadBefore(l2, l1, size2 - size1);
    }
    if (remain > 0) {
      ListNode head = new ListNode(remain);
      head.next = ans;
      return head;
    } else {
      return ans;
    }
  }

  private int remain = 0;
  // 长的放在前面
  private ListNode addNoHeadBefore(ListNode l1, ListNode l2, int diff) {
    if (diff > 0) {
      ListNode next = addNoHeadBefore(l1.next, l2, --diff);
      int thisVal = l1.val + remain;
      remain = thisVal / 10;
      l1.val = thisVal % 10;
      l1.next = next;
      return l1;
    } else {
      if (l1.next != null) {
        ListNode next = addNoHeadBefore(l1.next, l2.next, diff);
        l1.next = next;
      }
      int thisVal = l1.val + l2.val + remain;
      remain = thisVal / 10;
      l1.val = thisVal % 10;
      return l1;
    }
  }

  private int culSize(ListNode ln) {
    int count = 0;
    while (ln != null) {
      ln = ln.next;
      count++;
    }
    return count;
  }
}
