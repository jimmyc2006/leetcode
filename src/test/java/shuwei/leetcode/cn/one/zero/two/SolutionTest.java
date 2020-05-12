package shuwei.leetcode.cn.one.zero.two;

import org.junit.Test;

import shuwei.leetcode.cn.nine.eight.TreeNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(s.levelOrder(root));
  }
}
