package shuwei.leetcode.cn.mst.two.one;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.ListNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals("1,2,3", s.removeDuplicateNodes(ListNode.gen("1, 2, 3, 3, 2, 1")).b2String());
    Assert.assertEquals("1,2", s.removeDuplicateNodes(ListNode.gen("1, 1, 1, 1, 2")).b2String());
  }
}
