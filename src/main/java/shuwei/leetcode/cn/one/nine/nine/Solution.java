package shuwei.leetcode.cn.one.nine.nine;

import java.util.ArrayList;
import java.util.List;

// 2020-07-26
public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    List<TreeNode> nextLevel = new ArrayList<>();
    nextLevel.add(root);
    while (nextLevel.size() > 0) {
      List<TreeNode> next = new ArrayList<>();
      ans.add(nextLevel.get(nextLevel.size() - 1).val);
      for (TreeNode tn : nextLevel) {
        if (tn.left != null) {
          next.add(tn.left);
        }
        if (tn.right != null) {
          next.add(tn.right);
        }
        nextLevel = next;
      }
    }
    return ans;
  }
}
