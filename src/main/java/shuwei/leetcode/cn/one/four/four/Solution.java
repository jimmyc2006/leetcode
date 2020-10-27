package shuwei.leetcode.cn.one.four.four;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    Deque<TreeNode> stack = new LinkedList<>();
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    stack.push(root);
    while (stack.size() > 0) {
      TreeNode node = stack.pop();
      ans.add(node.val);
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    return ans;
  }
}
