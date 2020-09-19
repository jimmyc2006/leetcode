package shuwei.leetcode.cn.four.zero.four;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return s(root);
  }

  private int s(TreeNode root) {
    int result = 0;
    if (root.left != null) {
      if (root.left.left == null && root.left.right == null) {
        result += root.left.val;
      } else {
        result += sumOfLeftLeaves(root.left);
      }
    }
    if (root.right != null) {
      result += sumOfLeftLeaves(root.right);
    }
    return result;
  }

}
