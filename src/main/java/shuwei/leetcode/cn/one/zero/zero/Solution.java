package shuwei.leetcode.cn.one.zero.zero;

import shuwei.leetcode.cn.TreeNode;

public class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    return isSame(p, q);
  }

  private boolean isSame(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    } else if (p == null) {
      return false;
    } else if(q == null) {
      return false;
    } else {
      if (p.val == q.val) {
        return isSame(p.left, q.left) && isSame(p.right, q.right);
      } else {
        return false;
      }
    }
  }
}
