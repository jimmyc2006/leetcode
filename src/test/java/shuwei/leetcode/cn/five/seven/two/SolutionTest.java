package shuwei.leetcode.cn.five.seven.two;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
  @Test  
  public void test() {
    Solution s = new Solution();
    System.out.println(s.dfs(gen3()));
    Assert.assertEquals(true, s.isSubtree(gen1(), gen2()));
    System.out.println(s.isSubtree(gen3(), gen4()));
  }
  
  private TreeNode gen1() {
    TreeNode curr, root;
    curr = root = new TreeNode(3);
    curr.left = new TreeNode(4);
    curr.right = new TreeNode(5);
    curr = curr.left;
    curr.left = new TreeNode(1);
    curr.right = new TreeNode(2);
    return root;
  }
  
  public TreeNode gen2() {
    TreeNode curr, root;
    curr = root = new TreeNode(4);
    curr.left = new TreeNode(1);
    curr.right = new TreeNode(2);
    return root;
  }
  
  private TreeNode gen3() {
    TreeNode curr, root;
    curr = root = new TreeNode(3);
    curr.left = new TreeNode(4);
    curr.right = new TreeNode(5);
    curr.left.left = new TreeNode(1);
    curr.left.right = new TreeNode(2);
    curr.left.left.left = new TreeNode(0);
    return root;
  }
  
  public TreeNode gen4() {
    TreeNode curr, root;
    curr = root = new TreeNode(4);
    curr.left = new TreeNode(1);
    curr.right = new TreeNode(2);
    return root;
  }
  
}
