package shuwei.leetcode.cn.six.three.seven;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    LinkedList<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (nodes.size() > 0) {
      long sum = 0;
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = nodes.pollFirst();
        sum += node.val;
        if (node.left != null) {
          nodes.add(node.left);
        }
        if (node.right != null) {
          nodes.add(node.right);
        }
      }
      ans.add(sum / (double) size);
    }
    return ans;
  }

}
