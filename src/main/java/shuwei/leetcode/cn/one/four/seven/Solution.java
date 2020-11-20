package shuwei.leetcode.cn.one.four.seven;

import shuwei.leetcode.cn.ListNode;

public class Solution {

  public ListNode insertionSortList(ListNode head) {
    //prev node dummyHead prev代表第一个，node代表第二个 对比 比较 dummyHead.next 挂head
    //prev.val跟node.val 如果prev.val > node.val 那么就生成temp 从dummyHead开始循环
    //一致比较temp.next.val跟node.val比较 如果temp.next.val一直小于node.val 就不断后移指针
    //否则跳出循环，把node.next赋给prev.next，把temp.next赋给node.next，把node赋给temp.next
    //把pre.next赋给node
    if(head == null || head.next == null) return head;
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    ListNode prev = head;
    ListNode node = head.next;
    while(node != null){
      if(prev.val > node.val){
        ListNode temp = dummyHead;
        while(temp.next.val < node.val){
          temp = temp.next;
        }
        prev.next = node.next;
        node.next = temp.next;
        temp.next = node;
        node = prev.next;
      }else{
        prev = prev.next;
        node = node.next;
      }
    }
    return dummyHead.next;
  }

  /**
   * 被取下的链表成员与原来断开，放入一个新的链表中
   */
  public ListNode insertionSortList1(ListNode head) {
    int times = 0;
    if (head == null) {
      return null;
    }
    ListNode result = head;
    ListNode curr = result.next;
    result.next = null;
    while (curr != null) {
      // 把curr往result里面插入
      ListNode next = curr.next;
      curr.next = null;
      if (curr.val <= result.val) {
        curr.next = result;
        result = curr;
        curr = next;
        continue;
      }
      ListNode resultCurr = result;
      while (true) {
        System.out.println(++times);
        ListNode resultNext = resultCurr.next;
        if (resultNext == null) {
          resultCurr.next = curr;
          break;
        } else if (curr.val > resultNext.val) {
          resultCurr = resultNext;
        } else {
          resultCurr.next = curr;
          curr.next = resultNext;
          break;
        }
      }
      curr = next;
    }
    return result;
  }

}
