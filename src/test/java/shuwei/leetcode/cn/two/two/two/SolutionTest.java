package shuwei.leetcode.cn.two.two.two;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(7, s.countNodes(TreeNode.gen("1,2,3,4,5,6,7")));
    Assert.assertEquals(6, s.countNodes(TreeNode.gen("1,2,3,4,5,6")));
    Assert.assertEquals(2, s.countNodes(TreeNode.gen("1,2")));
    Assert.assertEquals(3, s.countNodes(TreeNode.gen("1,2,3")));
  }
}
