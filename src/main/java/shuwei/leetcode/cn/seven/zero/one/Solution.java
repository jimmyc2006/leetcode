package shuwei.leetcode.cn.seven.zero.one;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode curr = root;
        while (curr != null){
            if (val > curr.val){
                if (curr.right == null){
                    curr.right = new TreeNode(val);
                    break;
                } else {
                    curr = curr.right;
                }
            } else {
                if (curr.left == null){
                    curr.left = new TreeNode(val);
                    break;
                } else {
                    curr = curr.left;
                }
            }
        }
        return root;
    }

}
