package shuwei.leetcode.cn.one.zero.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  /**
   * 采用广度优先搜索法
   */
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<TreeNode> list = new ArrayList<>();
    list.add(root);
    List<List<Integer>> ans = new ArrayList<>();
    // 表示方向，从左往右
    boolean isLeft = true;
    while (list != null && list.size() > 0) {
      List<TreeNode> nextList = new ArrayList<>();
      LinkedList<Integer> result = new LinkedList<>();
      for (int i = 0; i < list.size(); i++) {
        add(list.get(i), nextList, result, isLeft);
      }
      isLeft = !isLeft;
      ans.add(result);
      list = nextList;
    }
    return ans;
  }

  private void add(TreeNode node, List<TreeNode> nexts, LinkedList<Integer> result, boolean isLeft) {
    if (isLeft) {
      result.addLast(node.val);
    } else {
      result.addFirst(node.val);
    }
    addIfNotNull(node.left, nexts);
    addIfNotNull(node.right, nexts);
  }

  private void addIfNotNull(TreeNode node, List<TreeNode> list) {
    if (node != null) {
      list.add(node);
    }
  }
}
