package shuwei.leetcode.cn.three.three.seven;

import shuwei.leetcode.cn.TreeNode;

public class Solution {
    public int rob(TreeNode root) {
        return max(root)[0];
    }

    private int[] max(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = max(node.left);
        int[] right = max(node.right);
        int selectMax = node.val + left[1] + right[1];
        int noSelectMax = left[0] + right[0];
        return new int[]{Math.max(selectMax, noSelectMax), noSelectMax};
    }
}
