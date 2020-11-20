package shuwei.leetcode.cn.one.four.seven;

import org.junit.Test;

import shuwei.leetcode.cn.ListNode;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    ListNode listNode = s.insertionSortList(ListNode.gen("4,2,1,3"));
    System.out.println(listNode.b2String());
//    System.out.println(s.insertionSortList(ListNode.gen("-1,5,3,4,0")).b2String());
//    System.out.println(s.insertionSortList(ListNode.gen("4,0")).b2String());
//    System.out.println(s.insertionSortList(ListNode.gen("4")).b2String());
  }
}
