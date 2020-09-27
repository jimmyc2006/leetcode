package shuwei.leetcode.cn.two.three.five;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class Solution {
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    return null;
  }

  /**
   * 使用一个list记录路径，当2个node都找到以后，从前往遍历
   * 在发现第一个不相同的node之前的节点就是答案
   * 这个算法没有用到搜索树的特性
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    findCount = 0;
    find(root, p, q, new LinkedList<>());
    int count = 0;
    TreeNode result;
    if (node1List.size() > node2List.size()) {
      count = node2List.size();
      result = node2List.get(node2List.size() - 1);
    } else {
      count = node1List.size();
      result = node1List.get(node1List.size() - 1);
    }
    for (int i = 1; i < count; i++) {
      if (node1List.get(i) == null || node2List.get(i) == null) {
        return node2List.get(i - 1);
      } else if (node1List.get(i) != node2List.get(i)) {
        return node2List.get(i - 1);
      }
    }
    return result;
  }

  private List<TreeNode> node1List;
  private List<TreeNode> node2List;
  private int findCount = 0;

  private void find(TreeNode node, TreeNode p, TreeNode q, LinkedList<TreeNode> path) {
    if (findCount == 2) {
      return;
    }
    path.addLast(node);
    if (node.val == p.val || node.val == q.val) {
      findCount++;
      if (findCount == 1) {
        node1List = new ArrayList<>(path);
      } else {
        node2List = new ArrayList<>(path);
      }
    }
    if ((node.val > p.val || node.val > q.val) && node.left != null) {
      find(node.left, p, q, path);
    }
    if ((node.val < p.val || node.val < q.val) && node.right != null) {
      find(node.right, p, q, path);
    }
    path.removeLast();
  }
}
