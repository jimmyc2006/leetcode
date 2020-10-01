package shuwei.leetcode.cn.one.one.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class Solution {
  /**
   * 在遍历的同时，使用一个stack来记录路径
   * 使用递归思路比较清晰
   * @param root
   * @param sum
   * @return
   */
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    this.sum = sum;
    currSum = 0;
    xianxu(root, new LinkedList<>());
    return ans;
  }

  private int currSum;
  private int sum;
  private List<List<Integer>> ans;

  private void xianxu(TreeNode node, LinkedList<Integer> tmp) {
    tmp.add(node.val);
    currSum += node.val;
    if (node.left == null && node.right == null) {
      if (currSum == sum) {
        ans.add(new LinkedList<>(tmp));
      }
    }
    if (node.left != null) {
      xianxu(node.left, tmp);
    }
    if (node.right != null) {
      xianxu(node.right, tmp);
    }
      currSum -= node.val;
      tmp.removeLast();
  }
}
