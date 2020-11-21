package shuwei.leetcode.cn.one.four.eight;

import org.junit.Test;

import shuwei.leetcode.cn.ListNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    ListNode listNode = s.sortList(ListNode.gen("4,2,1,3"));
    System.out.println(listNode.b2String());
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    ListNode listNode = s.sortList(ListNode.gen("-1,5,3,4,0"));
    System.out.println(listNode.b2String());
  }
}
