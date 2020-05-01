package shuwei.leetcode.cn.two.one;

import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    this.print(s.mergeTwoLists(this.gen(new int[] {1, 2, 4}), this.gen(new int[] {1, 3, 4})));
  }

  public ListNode gen(int[] arr) {
    ListNode root = new ListNode(arr[0]);
    ListNode curr = root;
    for (int i = 1; i < arr.length; i++) {
      curr.next = new ListNode(arr[i]);
      curr = curr.next;
    }
    return root;
  }

  public void print(ListNode ln) {
    while (ln != null) {
      System.out.print(ln.val + " ");
      ln = ln.next;
    }
    System.out.println();
  }
}