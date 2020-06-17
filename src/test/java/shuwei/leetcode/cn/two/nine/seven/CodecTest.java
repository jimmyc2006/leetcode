package shuwei.leetcode.cn.two.nine.seven;

import org.junit.Test;

public class CodecTest {
    @Test
    public void test() {
        Codec testObj = new Codec();
        b(this.gen());
        System.out.println();
        String s = testObj.serialize(gen());
        TreeNode tn = testObj.deserialize(s);
        b(tn);
    }

    private void b(TreeNode root) {
        if (root != null){
            System.out.print(root.val + " ");
            b(root.left);
            b(root.right);
        } else {
            System.out.print("n" + " ");
        }
    }

    private TreeNode gen(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        return root;
    }
}
