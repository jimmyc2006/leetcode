package shuwei.leetcode.cn.two.three.five;

import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(s.lowestCommonAncestor(TreeNode.gen("6,2,8,0,4,7,9,null,null,3,5"), new TreeNode(2), new TreeNode(8)).val);
    System.out.println(s.lowestCommonAncestor(TreeNode.gen("6,2,8,0,4,7,9,null,null,3,5"), new TreeNode(2), new TreeNode(4)).val);

  }
}
