package shuwei.leetcode.cn.six.one;

import org.junit.Test;

import shuwei.leetcode.cn.ListNode;

public class SolutionTest {

  @Test
  public void test001() {
    Solution s = new Solution();
    ListNode listNode = s.rotateRight(ListNode.gen("1,2"), 1);
    System.out.println(listNode.b2String());
  }

  @Test
  public void test() {
    Solution s = new Solution();
    ListNode listNode = s.rotateRight(ListNode.gen("1,2,3,4,5"), 2);
    System.out.println(listNode.b2String());
  }

  @Test
  public void test1() {
    Solution s = new Solution();
    ListNode listNode = s.rotateRight(ListNode.gen("0,1,2"), 4);
    System.out.println(listNode.b2String());
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    ListNode listNode = s.rotateRight(ListNode.gen("0"), 4);
    System.out.println(listNode.b2String());
  }

  @Test
  public void test3() {
    Solution s = new Solution();
    ListNode listNode = s.rotateRight(null, 4);
    System.out.println(listNode);
  }
}
