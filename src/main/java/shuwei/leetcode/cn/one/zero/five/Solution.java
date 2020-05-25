package shuwei.leetcode.cn.one.zero.five;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  // 2hm， 98%
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length < 1) {
      return null;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return rootSub(preorder, 0, preorder.length, 0, inorder.length, map);
  }

  private TreeNode rootSub(int[] preorder, int pStart, int pEnd, int iStart, int iEnd, Map<Integer, Integer> map) {
    TreeNode thisRoot = new TreeNode(preorder[pStart]);
    int leftRemain = map.get(preorder[pStart]) - iStart;
    if (leftRemain > 0) {
      thisRoot.left = rootSub(preorder, pStart + 1, pStart + 1 + leftRemain, iStart, map.get(preorder[pStart]), map);
    } else {
      thisRoot.left = null;
    }
    if (leftRemain == pEnd - pStart - 1) {
      thisRoot.right = null;
    } else {
      thisRoot.right = rootSub(preorder, pStart + 1 + leftRemain, pEnd, map.get(preorder[pStart]) + 1, iEnd, map);
    }
    return thisRoot;
  }

//  public TreeNode buildTree1(int[] preorder, int[] inorder) {
//    if (preorder == null || preorder.length < 1) {
//      return null;
//    }
//    Map<Integer, Integer> iderMap = new HashMap<>();
//    for (int i = 0; i < inorder.length; i++) {
//      iderMap.put(inorder[i], i);
//    }
//    TreeNode root = new TreeNode(preorder[0]);
//    TreeNode tmp = root;
//    for (int i = 1; i < preorder.length;) {
//      if (iderMap.get(preorder[i]) < iderMap.get(tmp.val)) {
//        // 左边
//        if (tmp.left == null) {
//          tmp.left = new TreeNode(preorder[i]);
//          tmp = root;
//          i++;
//        } else {
//          tmp = tmp.left;
//        }
//      } else {
//        // 右边
//        if (tmp.right == null) {
//          tmp.right = new TreeNode(preorder[i]);
//          tmp = root;
//          i++;
//        } else {
//          tmp = tmp.right;
//        }
//      }
//    }
//    return root;
//  }
}
