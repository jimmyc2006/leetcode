package shuwei.leetcode.cn.nine.four;

import java.util.ArrayList;
import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    zhongxu(root, ans);
    return ans;
  }

  private void zhongxu(TreeNode node, List<Integer> result) {
    if (node.left != null) {
        zhongxu(node.left, result);
    }
    result.add(node.val);
    if (node.right != null) {
      zhongxu(node.right, result);
    }
  }
}
