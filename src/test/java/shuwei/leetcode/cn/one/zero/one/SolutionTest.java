package shuwei.leetcode.cn.one.zero.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.isSymmetric(gen1()));
    Assert.assertEquals(false, s.isSymmetric(gen2()));
    Assert.assertEquals(true, s.isSymmetric(null));
  }

  private TreeNode gen1() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);
    return root;
  }

  private TreeNode gen2() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    return root;
  }
}
