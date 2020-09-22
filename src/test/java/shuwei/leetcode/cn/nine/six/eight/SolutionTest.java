package shuwei.leetcode.cn.nine.six.eight;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.minCameraCover(TreeNode.gen("0,null,0,0,0,null,null,null,0")));
    Assert.assertEquals(2, s.minCameraCover(TreeNode.gen("0,null,0,null,0,null,0")));
    Assert.assertEquals(2, s.minCameraCover(TreeNode.gen("0,0,null,null,0,0,null,null,0,0")));
    Assert.assertEquals(2, s.minCameraCover(TreeNode.gen("0,0,0,null,null,null,0")));
    Assert.assertEquals(1, s.minCameraCover(TreeNode.gen("0,0,null,0,0")));
    Assert.assertEquals(1, s.minCameraCover(TreeNode.gen("0")));
  }
}
