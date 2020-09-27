package shuwei.leetcode.cn.six.one.seven;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    return merge(t1, t2);
  }

  private TreeNode merge(TreeNode t1, TreeNode t2) {
    TreeNode t3 = null;
    if (t1 != null && t2 != null) {
      t3 = new TreeNode(t1.val + t2.val);
      t3.left = merge(t1.left, t2.left);
      t3.right = merge(t1.right, t2.right);
    } else if (t1 != null) {
      return t1;
    } else if (t2 != null) {
      return t2;
    }
    return t3;
  }
}
