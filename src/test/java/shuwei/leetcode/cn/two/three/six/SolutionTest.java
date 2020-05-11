package shuwei.leetcode.cn.two.three.six;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    TreeNode root = this.gen1();
    Assert.assertEquals(root, s.lowestCommonAncestor(root, root.left, root.right));
    Assert.assertEquals(5, s.lowestCommonAncestor(root, root.left, root.left.right.right).val);
  }
  
  @Test
  public void test2() {
    Solution s = new Solution();
    TreeNode root = this.gen2();
    System.out.println(s.lowestCommonAncestor(root, root, root.left).val);
  }
  
  private TreeNode gen1() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    return root;
  }
  
  private TreeNode gen2() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    return root;
  }
}
