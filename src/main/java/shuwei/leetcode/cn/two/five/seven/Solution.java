package shuwei.leetcode.cn.two.five.seven;

import java.util.ArrayList;
import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class Solution {


  public List<String> binaryTreePaths(TreeNode root) {
    ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    sb = new StringBuilder();
    sb.append(root.val);
    dfs(root);
    return ans;
  }

  private StringBuilder sb;
  private List<String> ans;
  private static String SIGN = "->";

  private void dfs(TreeNode node) {
    if (node.left == null && node.right == null) {
      ans.add(sb.toString());
    } else {
      sb.append(SIGN);
      int start = sb.length();
      if (node.left != null) {
        sb.append(node.left.val);
        dfs(node.left);
        sb.delete(start, sb.length());
      }
      if (node.right != null) {
        sb.append(node.right.val);
        dfs(node.right);
        sb.delete(start, sb.length());
      }
      sb.deleteCharAt(sb.length() - 1);
    }
  }

}
