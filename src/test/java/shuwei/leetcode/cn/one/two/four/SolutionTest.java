package shuwei.leetcode.cn.one.two.four;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(6, s.maxPathSum(TreeNode.gen("1,2,3")));
    Assert.assertEquals(42, s.maxPathSum(TreeNode.gen("-10,9,20,null,null,15,7")));
    Assert.assertEquals(0, s.maxPathSum(TreeNode.gen("0")));
  }
}
