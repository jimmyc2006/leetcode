package shuwei.leetcode.one.one.zero;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  public boolean isBalanced(TreeNode root) {
    return deep(root) != bad;
  }

  private static final int bad = -2;
  private int deep(TreeNode tn) {
    if (tn == null) {
      return 0;
    }
    int leftDeep = deep(tn.left);
    if (leftDeep == bad) {
      return bad;
    }
    int rightDeep = deep(tn.right);
    if (rightDeep == bad) {
      return bad;
    }
    if (rightDeep >= leftDeep) {
      if (rightDeep - leftDeep > 1) {
        return bad;
      } else {
        return rightDeep + 1;
      }
    } else {
      if ( leftDeep - rightDeep > 1) {
        return bad;
      } else {
        return leftDeep + 1;
      }
    }
  }
}
