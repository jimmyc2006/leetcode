package shuwei.leetcode.cn.one.one.two;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    return addAndJudge(root, 0, sum);
  }

  private boolean addAndJudge(TreeNode tn, int beforeSum, int sum) {
    if (tn == null) {
      return false;
    }
    beforeSum += tn.val;
    if (tn.left == null && tn.right == null) {
      if (beforeSum == sum) {
        return true;
      } else {
        return false;
      }
    }
    return addAndJudge(tn.left, beforeSum, sum) || addAndJudge(tn.right, beforeSum, sum);
  }
}
