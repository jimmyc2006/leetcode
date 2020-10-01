package shuwei.leetcode.cn.nine.six.eight;

import shuwei.leetcode.cn.TreeNode;

public class Solution {


  public int minCameraCover(TreeNode root) {
    ans = 0;
    deal(root, null);
    return ans;
  }

  private int ans;

  /**
   * 0表示该节点需要被上游照亮
   * 1表示该节点上有摄像头
   * 2表示该节点已经被照亮
   * 没有父节点时候，如果当前节点的状态是0，则需要加摄像头
   * @param node
   * @return
   */
  private int deal(TreeNode node, TreeNode parent) {
    if (node.left == null && node.right == null) {
      if (parent == null) {
        ans++;
      }
      return 0;
    }
    int result = 0;
    if (node.left != null) {
      int leftStatus = deal(node.left, node);
      if (leftStatus == 0) {
        node.val = 1;
        ans++;
        result = 1;
      } else if (leftStatus == 1) {
        result = 2;
      }
    }
    if (node.right != null) {
      int rightStatus = deal(node.right, node);
      if (rightStatus == 0 && node.val != 1) {
        node.val = 1;
        ans++;
        result = 1;
      } else if (rightStatus == 1 && result == 0){
        result = 2;
      }
    }
    if (parent == null && result == 0) {
      ans++;
    }
    return result;
  }
}
