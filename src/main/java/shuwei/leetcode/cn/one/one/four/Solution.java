package shuwei.leetcode.cn.one.one.four;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  public void flatten(TreeNode root) {
    if(root == null) {
      return;
    }
    this.beforeBrowse(root);
  }

  private TreeNode beforeBrowse(TreeNode node) {
    if (node.left != null && node.right != null) {
      TreeNode right = node.right;
      node.right = node.left;
      TreeNode end = beforeBrowse(node.left);
      end.right = right;
      node.left = null;
      return beforeBrowse(right);
    } else if (node.left != null) {
      node.right = node.left;
      node.left = null;
      return beforeBrowse(node.right);
    } else if (node.right != null){
      return beforeBrowse(node.right);
    } else {
      return node;
    }
  }

}
