package shuwei.leetcode.cn.one.zero.two.eight;

import shuwei.leetcode.cn.TreeNode;

public class Solution {
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() < 1) {
            return null;
        }
        int nextSign =  S.indexOf(SIGN);
        TreeNode root;
        if (nextSign == -1) {
            return new TreeNode(Integer.parseInt(S));
        } else {
            root = new TreeNode(Integer.parseInt(S.substring(0, nextSign)));
        }
        dfsB(S, nextSign, 1, root);
        return root;
    }
    private static final char SIGN= '-';

    private int dfsB(String str, int start, int level, TreeNode parent) {
        if (start >= str.length() || start == -1) {
            return start;
        }
        if (match(str, start, level)) {
            int nextSIndex = str.indexOf(SIGN, start + level);
            int val;
            if (nextSIndex >= 0) {
                val = Integer.parseInt(str.substring(start + level, nextSIndex));
            } else {
                val = Integer.parseInt(str.substring(start + level));
            }
            TreeNode left = new TreeNode(val);
            parent.left = left;
            start = dfsB(str, nextSIndex, level + 1, left);
        }
        if (match(str, start, level)) {
            int nextSIndex = str.indexOf(SIGN, start + level);
            int val;
            if (nextSIndex >= 0) {
                val = Integer.parseInt(str.substring(start + level, nextSIndex));
            } else {
                val = Integer.parseInt(str.substring(start + level));
            }
            TreeNode right = new TreeNode(val);
            parent.right = right;
            start = dfsB(str, nextSIndex, level + 1, right);
        }
        return start;
    }

    private boolean match(String str, int start, int level) {
        if (start == -1 || start + level >= str.length()) {
            return false;
        }
        for (int i = 0; i < level; i++) {
            if (str.charAt(start + i) != SIGN) {
                return false;
            }
        }
        return true;
    }
}
