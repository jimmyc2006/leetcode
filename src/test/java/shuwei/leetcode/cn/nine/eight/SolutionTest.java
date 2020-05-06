package shuwei.leetcode.cn.nine.eight;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
//    Assert.assertEquals(true, s.isValidBST(gen()));
//    Assert.assertEquals(false,s.isValidBST(this.gen2()));
    System.out.println(s.isValidBST(this.gen3()));
  }
  
  public TreeNode gen() {
    TreeNode tn = new TreeNode(2);
    tn.left = new TreeNode(1);
    tn.right = new TreeNode(3);
    return tn;
  }
  
  public TreeNode gen2() {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    TreeNode tn = root.right;
    tn.left = new TreeNode(3);
    tn.right = new TreeNode(6);
    return root;
  }
  
  public TreeNode gen3() {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(15);
    TreeNode tn = root.right;
    tn.left = new TreeNode(6);
    tn.right = new TreeNode(20);
    return root;
  }
}