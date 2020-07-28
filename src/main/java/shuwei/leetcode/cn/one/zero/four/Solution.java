package shuwei.leetcode.cn.one.zero.four;

import shuwei.leetcode.cn.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        return deep(root);
    }

    private int deep(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(deep(node.left), deep(node.right));
        }
    }
}
