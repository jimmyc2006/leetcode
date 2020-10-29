package shuwei.leetcode.cn.one.zero.two.nine;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(25, s.sumNumbers(TreeNode.gen("1,2,3")));
    Assert.assertEquals(1026, s.sumNumbers(TreeNode.gen("4,9,0,5,1")));
  }
}
