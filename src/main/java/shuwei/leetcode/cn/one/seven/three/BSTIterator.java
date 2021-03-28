package shuwei.leetcode.cn.one.seven.three;

import java.util.PriorityQueue;

import shuwei.leetcode.cn.TreeNode;

public class BSTIterator {

  private PriorityQueue<Integer> data = new PriorityQueue<>();

  public BSTIterator(TreeNode root) {
    init(root);
  }

  private void init (TreeNode node) {
    if (node == null) {
      return;
    }
    data.add(node.val);
    init(node.left);
    init(node.right);
  }

  public int next() {
    return data.poll();
  }

  public boolean hasNext() {
    return !data.isEmpty();
  }
}
