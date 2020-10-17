package shuwei.leetcode.cn.two.four;

import org.junit.Test;

import shuwei.leetcode.cn.ListNode;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    ListNode listNode = s.swapPairs(ListNode.gen("1,2,3,4"));
    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }


}
