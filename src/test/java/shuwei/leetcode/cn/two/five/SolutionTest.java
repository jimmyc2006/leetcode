package shuwei.leetcode.cn.two.five;

import org.junit.Test;

import shuwei.leetcode.cn.ListNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    ListNode ln1 = s.reverseKGroup(gen(), 2);
    print(ln1);
    System.out.println();
    ln1 = s.reverseKGroup(gen(), 3);
    print(ln1);
    
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    print(s.reverseKGroup(gen2(), 3));
  }
  
  private void print(ListNode ln) {
    while(ln != null) {
      System.out.print(ln.val + " ");
      ln = ln.next;
    }
  }
  
  private ListNode gen() {
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    root.next.next = new ListNode(3);
    root.next.next.next = new ListNode(4);
    root.next.next.next.next = new ListNode(5);
    return root;
  }
  
  private ListNode gen2() {
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    return root;
  }
}
