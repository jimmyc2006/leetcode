package shuwei.leetcode.cn.addTwoNumber2;

import shuwei.leetcode.cn.ListNode;

/**
* @author shuwei 
* @version 创建时间：2020年4月14日 下午5:18:05 
* 类说明 
*/
public class Revert {
  public static void main(String[] args) {
    ListNode l2 = Solution.generate(1, 2, 3, 4);
    System.out.println(Solution.traversal(l2));
    System.out.println(Solution.traversal(revert(l2)));
  }
  // 反转一个链表
  public static ListNode revert(ListNode ln) {
    ListNode curr = ln;
    ListNode pre = null;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
    }
    return pre;
  }
}
