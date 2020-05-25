package shuwei.leetcode.cn.two.five;

public class Solution {
  
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode result = null;
    ListNode curr = head;
    ListNode pageHead = head;
    ListNode nextPageHead = null;
    ListNode prev = pageHead;
    int count = 0;
    while (curr != null) {
      count++;
      if (count == k) {
        // 记录下一段的头部
        nextPageHead = curr.next;
        // 切断
        curr.next = null;
        if (result == null) {
          result = reverseList(pageHead);
        } else {
          prev.next = reverseList(pageHead);
        }
        prev = pageHead;
        count = 0;
        pageHead = curr = nextPageHead;
      } else {
        curr = curr.next;
      }
    }
    if (count > 0) {
      prev.next = nextPageHead;
    }
    return result;
  }
  
  public ListNode reverseList(ListNode head) {
    ListNode prev = head;
    ListNode tmp = prev.next;
    prev.next = null;
    while (tmp != null) {
      ListNode next = tmp.next;
      tmp.next = prev;
      prev = tmp;
      tmp = next;
    }
    return prev;
  }
  
  // 这个方法的性能不是太好50%+
  public ListNode reverseKGroup1(ListNode head, int k) {
    ListNode[] arr = new ListNode[k];
    ListNode root = null;
    ListNode curr = head;
    ListNode tail = null;
    int i = 0;
    while (curr != null) {
      arr[i++] = curr;
      curr = curr.next;
      if (i == k) {
        // 反转
        for (int j = k - 1; j > 0; j--) {
          arr[j].next = arr[j -1];
        }
        if (root == null) {
          root = arr[k - 1];
        }
        if (tail != null) {
          tail.next = arr[k - 1];
        }
        tail = arr[0];
        tail.next = null;
        i = 0;
      }
    }
    if ( i > 0) {
      tail.next = arr[0];
    }
    return root;
  }
}
