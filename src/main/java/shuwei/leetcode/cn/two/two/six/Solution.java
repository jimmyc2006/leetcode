package shuwei.leetcode.cn.two.two.six;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    reverse(root);
    return root;
  }

  private void reverse(TreeNode root) {
    TreeNode tmp = root.right;
    root.right = root.left;
    root.left = tmp;
    if (root.left != null) {
      reverse(root.left);
    }
    if (root.right != null) {
      reverse(root.right);
    }
  }

}
