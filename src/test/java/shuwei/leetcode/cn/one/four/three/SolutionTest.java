package shuwei.leetcode.cn.one.four.three;

import org.junit.Test;

import shuwei.leetcode.cn.ListNode;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    ListNode nodes = ListNode.gen("1,2,3,4");
    s.reorderList(nodes);
    print(nodes);
    nodes = ListNode.gen("1,2,3,4,5");
    s.reorderList(nodes);
    System.out.println("-------");
    print(nodes);

  }

  private void print(ListNode nodes) {
    while (nodes != null) {
      System.out.println(nodes.val);
      nodes = nodes.next;
    }
  }
}
