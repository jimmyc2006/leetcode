package shuwei.leetcode.cn.one.zero.eight;

import shuwei.leetcode.cn.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return genTreeNode(nums, 0, nums.length);
    }

    private TreeNode genTreeNode(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int middle = (start + end) >>> 1;
        TreeNode parent = new TreeNode(nums[middle]);
        parent.left = genTreeNode(nums, start, middle);
        parent.right = genTreeNode(nums, middle + 1, end);
        return parent;
    }
}
