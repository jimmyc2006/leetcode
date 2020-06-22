package shuwei.leetcode.cn.one.two.four;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    ans = Integer.MIN_VALUE;
    afterB(root);
    return ans;
  }
  int ans;
  // 每个节点可能有3个连接点，从下往上遍历的时候能同时求出左右子节点的最大值
  // 包含当前节点的最终解，可能是当前节点连接的左右子节点的最大值，此时已经闭合
  // 也可能是包含左右子节点的最大值，与上游的值组成的解，这种情况包含在递归中
  private int afterB(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int afterLeft = afterB(root.left);
    int afterRight = afterB(root.right);
    int thisNodeMax = Math.max(root.val, root.val + afterLeft);
    thisNodeMax = Math.max(thisNodeMax, root.val + afterRight);
    // 包含此node且只包含左右节点其中一个的最大值的情况,可能不是最终值
    ans = Math.max(ans, thisNodeMax);
    // 此节点作为左右子节点连线时候的值，已经是最终值
    ans = Math.max(ans, afterLeft + root.val + afterRight);
    return thisNodeMax;
  }
}
