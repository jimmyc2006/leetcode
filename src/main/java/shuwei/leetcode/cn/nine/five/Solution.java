package shuwei.leetcode.cn.nine.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class Solution {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return Arrays.asList();
    }
    return this.gen(1, n + 1);
  }

  private List<TreeNode> gen(int start, int end) {
    if (start >= end) {
      return null;
    }
    List<TreeNode> result = new ArrayList<>();
    for (int i = start; i < end; i++) {
      List<TreeNode> left = gen(start, i);
      List<TreeNode> right = gen(i + 1, end);
      if (left == null && right == null) {
        return Arrays.asList(new TreeNode(start));
      } else if (left == null) {
        for (TreeNode r : right) {
          TreeNode root = new TreeNode(i);
          root.right = r;
          result .add(root);
        }
      } else if (right == null) {
        for (TreeNode l : left) {
          TreeNode root = new TreeNode(i);
          root.left = l;
          result .add(root);
        }
      } else {
        for (TreeNode l : left) {
          for (TreeNode r : right) {
            TreeNode root = new TreeNode(i);
            root.left = l;
            root.right = r;
            result.add(root);
          }
        }
      }
    }
    return result;
  }
}
