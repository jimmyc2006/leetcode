package shuwei.leetcode.cn.one.zero.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import shuwei.leetcode.cn.nine.eight.TreeNode;

public class Solution {
  // BFS
  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<List<TreeNode>> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    queue.add(Arrays.asList(root));
    while (!queue.isEmpty()) {
      List<TreeNode> tmpList = queue.poll();
      List<TreeNode> tQueue = new ArrayList<>(tmpList.size() * 2);
      List<Integer> tResult = new ArrayList<>(tmpList.size() * 2);
      for (TreeNode tn : tmpList) {
        tResult.add(tn.val);
        if (tn.left != null) {
          tQueue.add(tn.left);
        }
        if (tn.right != null) {
          tQueue.add(tn.right);
        }
      }
      if (!tQueue.isEmpty()) {
        queue.add(tQueue);
      }
      result.add(tResult);
    }
    return result;
  }
}
