package shuwei.leetcode.cn.one.one.one;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return minLevel(root);
  }
  private int minLevel(TreeNode node) {
    if (node.left == null && node.right == null) {
      return 1;
    }
    int min = Integer.MAX_VALUE;
    if (node.left != null) {
      min = Math.min(min, minLevel(node.left));
    }
    if (node.right != null) {
      min = Math.min(min, minLevel(node.right));
    }
    return min + 1;
  }
}
