package shuwei.leetcode.cn.two.three;

import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    ListNode result = s.mergeKLists(new ListNode[] {
        genList(new int[] {1, 4, 5}), 
        genList(new int[] {1, 3, 4}), 
        genList(new int[] {2, 6})
    });
    browse(result);
  }
  
  private ListNode genList(int[] data) {
    ListNode root = new ListNode(data[0]);
    ListNode curr = root;
    for (int i = 1; i < data.length; i++) {
      ListNode ln = new ListNode(data[i]);
      curr.next = ln;
      curr = ln;
    }
    return root;
  }
  
  private void browse(ListNode root) {
    while(root != null) {
      System.out.print(root.val + " ");
      root = root.next;
    }
  }
}
