package shuwei.leetcode.cn.three.two.eight;

import shuwei.leetcode.cn.ListNode;

public class S20201113 {

  /**
   * 1 2 3 4 5 null
   * 1指向3，2指向4，记住2的引用
   * 3指向5
   * @param head
   * @return
   */
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode firstEven = head.next;
    ListNode odd = head;
    ListNode even = head.next;
    ListNode current = even.next;
    boolean isOdd = true;
    while (current != null) {
      if (isOdd) {
        odd.next = current;
        odd = current;
        isOdd = false;
      } else {
        even.next = current;
        even = current;
        isOdd = true;
      }
      current = current.next;
    }
    odd.next = firstEven;
    even.next = null;
    return head;
  }

}
