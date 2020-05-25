package shuwei.leetcode.cn.one.zero.five;

import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    int[] pre = new int[]{3, 9, 8, 6, 20, 15, 7};
    int[] mid = new int[]{8, 9, 6, 3, 15, 20, 7};
    TreeNode tn = s.buildTree(pre, mid);
    pre(tn);
    System.out.println();
    mid(tn);
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    int[] pre = new int[]{1, 2, 3, 4};
    int[] mid = new int[]{1, 2, 3, 4};
    TreeNode tn = s.buildTree(pre, mid);
    pre(tn);
    System.out.println();
    mid(tn);
  }

  @Test
  public void test3() {
    Solution s = new Solution();
    int[] pre = new int[]{1, 4, 2, 3};
    int[] mid = new int[]{1, 2, 3, 4};
    TreeNode tn = s.buildTree(pre, mid);
    pre(tn);
    System.out.println();
    mid(tn);
  }

  private void pre(TreeNode tn) {
    System.out.print(tn.val + " ");
    if (tn.left != null) {
      pre(tn.left);
    }
    if (tn.right != null) {
      pre(tn.right);
    }
  }

  private void mid(TreeNode tn) {
    if (tn.left != null) {
      mid(tn.left);
    }
    System.out.print(tn.val + " ");
    if (tn.right != null) {
      mid(tn.right);
    }
  }
}