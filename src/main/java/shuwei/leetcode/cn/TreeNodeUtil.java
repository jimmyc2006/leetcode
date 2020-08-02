package shuwei.leetcode.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtil {

    public static String bfsBrowse(TreeNode tn) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tn);
        boolean hasNext = true;
        while (!queue.isEmpty() && hasNext) {
            hasNext = false;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode tmpTN = queue.poll();
                sb.append( (tmpTN == null ? "null" : tmpTN.val) + ",");
                if (tmpTN == null) {
                    queue.add(null);
                    queue.add(null);
                } else {
                    if (tmpTN.left != null) {
                        hasNext = true;
                        queue.add(tmpTN.left);
                    } else {
                        queue.add(null);
                    }
                    if (tmpTN.right != null) {
                        queue.add(tmpTN.right);
                        hasNext = true;
                    } else {
                        queue.add(null);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void beforeB(TreeNode tn) {
        beforeBInner(tn);
    }

    private static void beforeBInner(TreeNode tn) {
        System.out.print(tn.val + " ");
        if (tn.left != null) {
            beforeBInner(tn.left);
        }
        if (tn.right != null) {
            beforeBInner(tn.right);
        }
    }
}