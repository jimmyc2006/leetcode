package shuwei.leetcode.cn.three.two.eight;

import org.junit.Test;

import shuwei.leetcode.cn.ListNode;

public class S20201113Test {

  @Test
  public void test() {
    S20201113 s = new S20201113();
    ListNode listNode = s.oddEvenList(ListNode.gen("1,2,3,4,5"));
    System.out.println(listNode.b2String());
  }

  @Test
  public void test2() {
    S20201113 s = new S20201113();
    ListNode listNode = s.oddEvenList(ListNode.gen("2,1,3,5,6,4,7"));
    System.out.println(listNode.b2String());
  }
}
