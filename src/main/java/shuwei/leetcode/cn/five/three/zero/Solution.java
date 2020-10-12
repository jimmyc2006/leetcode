package shuwei.leetcode.cn.five.three.zero;

import shuwei.leetcode.cn.TreeNode;

public class Solution {
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        middle(root);
        return ans;
    }

    private Integer curr;
    private int ans;

    private void middle(TreeNode node) {
        if (node.left != null) {
            middle(node.left);
        }
        if (curr == null) {
            curr = node.val;
        } else {
            ans = Math.min(ans, node.val - curr);
            curr = node.val;
        }
        if (node.right != null) {
            middle(node.right);
        }
    }

}
