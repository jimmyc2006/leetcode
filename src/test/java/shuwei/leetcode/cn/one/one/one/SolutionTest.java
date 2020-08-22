package shuwei.leetcode.cn.one.one.one;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.minDepth(TreeNode.gen("1,2")));
    Assert.assertEquals(2, s.minDepth(TreeNode.gen("3,9,20,null,null,15,7")));
    Assert.assertEquals(0, s.minDepth(null));
    Assert.assertEquals(1, s.minDepth(new TreeNode(22)));
  }
}
