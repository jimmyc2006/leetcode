package shuwei.leetcode.cn.one.four.two;

import org.junit.Test;

import shuwei.leetcode.cn.ListNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    ListNode gen = ListNode.gen("3,2,0,-4");
    ListNode curr = gen;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = gen.next;
    ListNode listNode = s.detectCycle(gen);
    ListNode listNode1 = s.detectCycle(gen);
    System.out.println(listNode1.val);
  }
}
