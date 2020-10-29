package shuwei.leetcode.cn.one.zero.two.nine;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  public int sumNumbers(TreeNode root) {
    ans = 0;
    if (root == null) {
      return ans;
    } else {
      dfs(root, 0);
    }
    return ans;
  }

  private int ans;

  private void dfs(TreeNode node, int cur) {
    int num = cur * 10 + node.val;
    if (node.left == null && node.right == null) {
      ans += num;
    }
    if (node.left != null) {
      dfs(node.left, num);
    }
    if (node.right != null) {
      dfs(node.right, num);
    }
  }
}
