package shuwei.leetcode.cn.two.three.six;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {
  
  // 记录上游的方法,最快13ms，20%
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    browse(root, p, q, map);
    Set<TreeNode> tpSet = new HashSet<>(); 
    while (p != null) {
      tpSet.add(p);
      p = map.get(p);
    }
    while (q != null) {
      if (tpSet.contains(q)) {
        return q;
      }
      q = map.get(q);
    }
    return root;
  }
  
  private void browse(TreeNode root, TreeNode p, TreeNode q, Map<TreeNode, TreeNode> map) {
    if (map.get(p) != null && map.get(q) != null) {
      return;
    }
    TreeNode left = root.left;
    if (left != null) {
      map.put(left, root);
      browse(left, p, q, map);
    }
    TreeNode right = root.right;
    if (right != null) {
      map.put(right, root);
      browse(right, p, q, map);
    }
  }
  
  // 看解题思路以后的代码，居然8ms，超过86%
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    return houxu(root, p, q);
  }
  private TreeNode houxu(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode left = null, right = null;
    if (root.left != null) {
      left = houxu(root.left, p, q);
    }
    if (root.right != null) {
      right = houxu(root.right, p, q);
    }
    if (root == p || root == q) {
      return root;
    }
    if (left != null && right != null) {
      return root;
    } else if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    } else {
      return null;
    }
  }

  // DFS
  public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    Stack<TreeNode> stack = new Stack<>();
    List<TreeNode> listP = new ArrayList<>();
    List<TreeNode> listQ = new ArrayList<>();
    TreeNode curr = root;
    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode tn = stack.peek();
      if (tn == p && listP.isEmpty()) {
        listP.addAll(stack);
        if (!listQ.isEmpty()) {
          break;
        }
      } else if (tn == q && listQ.isEmpty()) {
        listQ.addAll(stack);
        if (!listP.isEmpty()) {
          break;
        }
      } else {
        if (curr == tn.left) {
          if (tn.right != null) {
            curr = tn.right;
            stack.add(curr);
          } else {
            curr = stack.pop();
          }
        } else if (curr == tn.right) {
          curr = stack.pop();
        } else {
          if (tn.left != null) {
            stack.add(tn.left);
          } else if (tn.right != null) {
            stack.add(tn.right);
          } else {
            curr = stack.pop();
          }
        }
      }
    }
    int i = 0;
    while (true) {
      if (i >= listP.size()) {
        return listP.get(i - 1);
      }
      if (i >= listQ.size()) {
        return listQ.get(i - 1);
      }
      if (listP.get(i) == listQ.get(i)) {
        i++;
      } else {
        return listP.get(i - 1);
      }
    }
  }
}
