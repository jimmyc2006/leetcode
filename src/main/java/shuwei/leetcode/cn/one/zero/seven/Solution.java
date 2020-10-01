package shuwei.leetcode.cn.one.zero.seven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    bfs(Arrays.asList(root));
    return ans;
  }

  private List<List<Integer>> ans;

  private void bfs(List<TreeNode> nodes) {
    if (nodes.size() > 0) {
      List<Integer> res = new ArrayList<>();
      List<TreeNode> nexts = new ArrayList<>();
      for (TreeNode tn : nodes) {
        if (tn.left != null) {
          nexts.add(tn.left);
        }
        if (tn.right != null) {
          nexts.add(tn.right);
        }
        res.add(tn.val);
      }
      bfs(nexts);
      ans.add(res);
    }
  }
}
