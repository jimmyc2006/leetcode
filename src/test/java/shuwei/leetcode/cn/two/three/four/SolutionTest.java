package shuwei.leetcode.cn.two.three.four;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.ListNode;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertFalse(s.isPalindrome(ListNode.gen("1,1,2,1")));
    Assert.assertTrue(s.isPalindrome(ListNode.gen("1")));
    Assert.assertTrue(s.isPalindrome(ListNode.gen("1,2,3,2,1")));
    Assert.assertFalse(s.isPalindrome(ListNode.gen("1,2")));
    Assert.assertTrue(s.isPalindrome(ListNode.gen("1,2,2,1")));
  }

}
