package shuwei.leetcode.one.one.zero;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.isBalanced(TreeNode.gen("3,9,20,null,null,15,7")));
    Assert.assertEquals(false, s.isBalanced(TreeNode.gen("1,2,2,3,3,null,null,4,4")));
  }
}
