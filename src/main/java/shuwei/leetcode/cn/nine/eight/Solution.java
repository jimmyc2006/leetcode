package shuwei.leetcode.cn.nine.eight;

public class Solution {

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isValid(root, null, null);
  }

  private boolean isValid(TreeNode treeNode, Integer max, Integer min) {
    if (treeNode == null) {
      return true;
    }
    if (min != null && treeNode.val <= min) {
      return false;
    }
    if (max != null && treeNode.val >= max) {
      return false;
    }
    return isValid(treeNode.left, max == null ? treeNode.val : Math.min(treeNode.val, max), min)
        && isValid(treeNode.right, max, min == null ? treeNode.val : Math.max(min, treeNode.val));
  }
}
