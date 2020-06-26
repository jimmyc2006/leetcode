package shuwei.leetcode.cn.addTwoNumber1;

import shuwei.leetcode.cn.ListNode;

/**
* @author shuwei 
* @version 创建时间：2020年4月14日 下午7:28:19 
* 类说明 
*/
public class Solution {
  public static void main(String[] args) {
    ListNode l1 = generate( 2, 4, 3);
    ListNode l2 = generate(5, 6, 4);
    Solution s = new Solution();
    System.out.println(traversal(l1));
    System.out.println(traversal(l2));
    System.out.println(traversal(s.addTwoNumbers(l1, l2)));
  }
  
  public static String traversal(ListNode ln) {
    StringBuilder sb = new StringBuilder();
    sb.append(ln.val);
    while (ln.next != null) {
      ln = ln.next;
      sb.append("->" + ln.val);
    }
    return sb.toString();
  }  
  public static ListNode generate(int start, int... vals) {
    ListNode root = new ListNode(start);
    ListNode curr = root;
    for (int i : vals) {
      ListNode next = new ListNode(i);
      curr.next = next;
      curr = next;
      
    }
    return root;
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode ans = null, cur = null;
    int remain = 0;
    while(l1 != null || l2 != null){
      if (l1 != null) {
        remain += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        remain += l2.val;
        l2 = l2.next;
      }
      if (ans == null) {
        ans =  new  ListNode(remain % 10);
        cur= ans;
      } else {
        cur.next = new ListNode(remain % 10);
        cur = cur.next;
      }
      remain = remain / 10;
    }
    if (remain > 0) {
      cur.next = new ListNode(remain);
    }
    return ans;
  }

  public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    ListNode curr = null;
    ListNode pre = null;
    ListNode head = null;
    int remain = 0;
    while (l1 != null || l2 != null) {
      int val;
      if (l1 != null && l2!= null) {
        val = l1.val + l2.val + remain;
        l1 = l1.next;
        l2 = l2.next;
      } else if (l1 != null) {
        val = l1.val + remain;
        l1 = l1.next;
      } else {
        val = l2.val + remain;
        l2 = l2.next;
      }
      if (val >= 10) {
        remain = 1;
        val = val - 10;
      } else {
        remain = 0;
      }
      curr = new ListNode(val);
      if (pre != null) {
        pre.next = curr;
      } else {
        head = curr;
      }
      pre = curr;
    }
    if (remain == 1) {
      curr = new ListNode(1);
      pre.next = curr;
    }
    return head;
  }
}
