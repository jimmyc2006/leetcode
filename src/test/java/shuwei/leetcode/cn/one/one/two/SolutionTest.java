package shuwei.leetcode.cn.one.one.two;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    TreeNode testData = TreeNode.gen("5,4,8,11,null, 13, 4, 7, 2,null,null,null, 1");
    Assert.assertEquals(true, s.hasPathSum(testData, 22));
    testData = TreeNode.gen("1,2,3");
    Assert.assertEquals(true, s.hasPathSum(testData, 4));
    Assert.assertEquals(false, s.hasPathSum(testData, 5));
    testData = TreeNode.gen("1");
    Assert.assertEquals(true, s.hasPathSum(testData, 1));
    Assert.assertEquals(false, s.hasPathSum(testData, 2));
    testData = TreeNode.gen("1,2");
    Assert.assertEquals(false, s.hasPathSum(testData, 1));
  }

}
