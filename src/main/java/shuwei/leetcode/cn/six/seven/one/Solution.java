package shuwei.leetcode.cn.six.seven.one;

import shuwei.leetcode.cn.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int rootVal;
    private Integer ans;
    public int findSecondMinimumValue(TreeNode root) {
        rootVal = root.val;
        ans = null;
        middle(root);
        return ans == null ? - 1 : ans;
    }

    private void middle(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val > rootVal) {
            if (ans == null) {
                ans = node.val;
            } else {
                ans = Math.min(ans, node.val);
            }
        } else if (node.val == rootVal) {
            middle(node.left);
            middle(node.right);
        }
    }
}
