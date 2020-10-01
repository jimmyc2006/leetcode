package shuwei.leetcode.cn.four.zero.four;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(24, s.sumOfLeftLeaves(TreeNode.gen("3,9,20,null,null,15,7")));
    Assert.assertEquals(0, s.sumOfLeftLeaves(TreeNode.gen("3")));
    Assert.assertEquals(0, s.sumOfLeftLeaves(null));
    Assert.assertEquals(4, s.sumOfLeftLeaves(TreeNode.gen("1,2,3,4,5")));
  }
}
