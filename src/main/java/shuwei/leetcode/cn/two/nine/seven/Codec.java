package shuwei.leetcode.cn.two.nine.seven;

public class Codec {
    // Encodes a tree to a single string.
    static final String SP = ",";
    static final String NULL = "N";

    public String serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        dealSerialize(root.left, sb);
        dealSerialize(root.right, sb);
        return sb.toString();
    }

    private void dealSerialize(TreeNode tn, StringBuilder sb) {
        if (tn == null) {
            this.append("N", sb);
        } else {
            this.append(Integer.toString(tn.val), sb);
            dealSerialize(tn.left, sb);
            dealSerialize(tn.right, sb);
        }
    }

    private void append(String c, StringBuilder sb) {
        sb.append(SP + c);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 1){
            return null;
        }
        String[] strs = data.split(SP);
        TreeNode root = this.genTreeNodeFromStr(strs[0]);
        dealDeserialize(strs, root, 1);
        return root;
    }

    private int dealDeserialize(String[] strs, TreeNode parent, int index) {
        if (index >= strs.length){
            return index;
        }
        TreeNode left = this.genTreeNodeFromStr(strs[index]);
        parent.left = left;
        int nextIndex;
        if (left != null) {
            nextIndex = dealDeserialize(strs, left, index + 1);
        } else {
            nextIndex = index + 1;
        }
        TreeNode right = this.genTreeNodeFromStr(strs[nextIndex]);
        parent.right = right;
        if (right != null){
            nextIndex = dealDeserialize(strs, right, nextIndex + 1);
        } else {
            nextIndex++;
        }
        return nextIndex;
    }

    private TreeNode genTreeNodeFromStr(String val) {
        if (val.equals("N")) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(val));
        }
    }
}
