package shuwei.leetcode.cn.one.one.six;

import shuwei.leetcode.cn.one.one.seven.Node;

public class Solution {

  public Node connect(Node root) {
    if (root == null) {
      return root;
    }
    deal(root, true);
    return root;
  }

  private Node deal(Node curr, boolean isHead) {
    if (curr.left != null) {
      curr.left.next = curr.right;
      if (curr.next != null) {
        curr.right.next = deal(curr.next, false);
      }
      if (isHead) {
        return deal(curr.left, isHead);
      } else {
        return curr.left;
      }
    }
    return null;
  }
}
