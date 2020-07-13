package shuwei.leetcode.cn.four.four.five;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.ListNode;
import shuwei.leetcode.cn.review.four.four.five.FourFourFiveSolution;

public class SolutionTest {
  @Test
  public void test() {
    FourFourFiveSolution s = new FourFourFiveSolution();
    Assert.assertEquals("7,8,0,7", s.addTwoNumbers(ListNode.gen("7,2,4,3"), ListNode.gen("5,6,4")).b2String());
    Assert.assertEquals("1,0", s.addTwoNumbers(ListNode.gen("5"), ListNode.gen("5")).b2String());
  }
}
