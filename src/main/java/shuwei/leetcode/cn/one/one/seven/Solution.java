package shuwei.leetcode.cn.one.one.seven;

public class Solution {
  /**
   * 每一行记录最左边的节点 遍历每一层的时候从左向右，找挨着的子节点，把它们连起来
   */
  public Node connect(Node root) {
    if (root == null) {
      return root;
    }
    next(root);
    return root;
  }

  //
  private void next(Node node) {
    Node first = null;
    Node current = null;
    while (node != null) {
      if (node.left != null) {
        if (first == null) {
          first = node.left;
          current = node.left;
        } else {
          current.next = node.left;
          current = node.left;
        }
      }
      if (node.right != null) {
        if (first == null) {
          first = node.right;
          current = node.right;
        } else {
          current.next = node.right;
          current = current.next;
        }
      }
      node = node.next;
    }
    if (first != null) {
      next(first);
    }
  }
}
