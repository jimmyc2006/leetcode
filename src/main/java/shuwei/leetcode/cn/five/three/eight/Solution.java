package shuwei.leetcode.cn.five.three.eight;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  /**
   * 使用先右后左的方式遍历
   * @param root
   * @return
   */
  public TreeNode convertBST(TreeNode root) {
    if (root == null) {
      return root;
    }
    rightSum(root, null);
    return root;
  }

  // 这个算法会出现问题，右边的节点是小于上面的节点的，所以需要带着
  // [5,6,3,2,6]
  private int rightSum(TreeNode node, TreeNode upNode) {
    if (node == null) {
      return upNode == null ? 0 : upNode.val;
    }
    int rightSum = rightSum(node.right, upNode);
    node.val = rightSum + node.val;
    int leftSum = rightSum(node.left, node);
    if (upNode != null) {
      return node.val + leftSum;
    } else {
      return node.val;
    }
  }
}
