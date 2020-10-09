package shuwei.leetcode.cn.one.four.five;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  /**
   * 迭代的方法,last来区分是否已经访问过当前的左节点或者右节点
   * @param root
   * @return
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    if (root == null) {
      return ans;
    } else {
      stack.push(root);
    }
    TreeNode last = null;
    while (stack.size() > 0) {
      TreeNode node = stack.peek();
      if (node.left == null && node.right == null) {
        ans.add(node.val);
        last = node;
        stack.pop();
        continue;
      }
      if (node.right != null) {
        if (last == node.right) {
          ans.add(node.val);
          last = node;
          stack.pop();
          continue;
        }
      }
      if (node.left != null) {
        if (last != node.left) {
          stack.push(node.left);
          continue;
        }
      }
      if (node.right != null) {
        stack.push(node.right);
      } else {
        stack.pop();
        ans.add(node.val);
        last = node;
      }
    }
    return ans;
  }

  /**
   * 先实现一个递归
   * @param root
   * @return
   */
  public List<Integer> postorderTraversal2(TreeNode root) {
    ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    b(root);
    return ans;
  }

  private List<Integer> ans;

  private void b(TreeNode node) {
    if (node.left != null) {
      b(node.left);
    }
    if (node.right != null) {
      b(node.right);
    }
    ans.add(node.val);
  }
}
