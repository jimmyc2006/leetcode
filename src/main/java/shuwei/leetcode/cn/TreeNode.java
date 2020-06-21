package shuwei.leetcode.cn;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    // [1,2,3]
    public static TreeNode gen(String info) {
        int start = 0, end = info.length();
        if (info.startsWith("[")) {
            start = 1;
        }
        if (info.endsWith("]")) {
            end = info.length() - 1;
        }
        info = info.substring(start, end);
        String[] strs = info.split(",");
        TreeNode root = gen(strs, "null");
        return root;
    }

    private static TreeNode gen(String[] strs, String nullStr) {
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < strs.length) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode tn = queue.poll();
                if (nullStr.equals(strs[i])) {
                    tn.left = null;
                    i++;
                } else {
                    tn.left = new TreeNode(Integer.parseInt(strs[i++].trim()));
                    queue.add(tn.left);
                }
                if (i >= strs.length) {
                    return root;
                }
                if (nullStr.equals(strs[i])) {
                    tn.right = null;
                    i++;
                } else {
                    tn.right = new TreeNode(Integer.parseInt(strs[i++].trim()));
                    queue.add(tn.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root2 = TreeNode.gen("-10,9,20,null,null,15,7");
        System.out.print(root2);
    }
}
