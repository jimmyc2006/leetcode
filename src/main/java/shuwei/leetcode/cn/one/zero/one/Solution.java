package shuwei.leetcode.cn.one.zero.one;

public class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetryI(root.left, root.right);
  }
  private boolean isSymmetryI(TreeNode tn1, TreeNode tn2) {
    if (tn1 != null && tn2 != null) {
      if (tn1.val == tn2.val) {
        return isSymmetryI(tn1.left, tn2.right) && isSymmetryI(tn1.right, tn2.left);
      } else {
        return false;
      }
    } else if (tn1 == null && tn2 == null) {
      return true;
    } else {
      return false;
    }
  }
}
