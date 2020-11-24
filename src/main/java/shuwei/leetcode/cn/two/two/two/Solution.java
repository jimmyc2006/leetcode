package shuwei.leetcode.cn.two.two.two;

import shuwei.leetcode.cn.TreeNode;

public class Solution {
  /**
   * 前序遍历，计算层级，最后一层遇到第一个null的时候停止
   */
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    maxLevel = 0;
    lowestLeaves = 0;
    countNode(root, 1);
    return (int) Math.pow(2, maxLevel) - 1 + lowestLeaves;
  }

  private int maxLevel;
  private int lowestLeaves;

  private void countNode(TreeNode root, int level) {
    if (maxLevel > 0) {
      if (level > maxLevel) {
        if (root == null) {
          return;
        }
        lowestLeaves++;
        return;
      } else {
        TreeNode left = root.left;
        if (left == null && level == maxLevel) {
          return;
        }
        countNode(left, level + 1);
        TreeNode right = root.right;
        if (right == null && level == maxLevel) {
          return;
        }
        countNode(right, level + 1);
      }
    } else {
      TreeNode left = root.left;
      // 一直往左的话，第一个左为空的时候的层级就是最大层级
      if (left == null) {
        maxLevel = level - 1;
        lowestLeaves++;
      } else {
        countNode(root.left, level + 1);
        countNode(root.right, level + 1);
      }
    }
  }
}
