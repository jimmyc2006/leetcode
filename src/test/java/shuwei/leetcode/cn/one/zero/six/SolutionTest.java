package shuwei.leetcode.cn.one.zero.six;

import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;
import shuwei.leetcode.cn.TreeNodeUtil;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    TreeNode treeNode = s.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    System.out.println(TreeNodeUtil.bfsBrowse(treeNode));
  }

  @Test
  public void test1() {
    Solution s = new Solution();
    TreeNode treeNode = s.buildTree(new int[]{9}, new int[]{9});
    System.out.println(TreeNodeUtil.bfsBrowse(treeNode));
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    TreeNode treeNode = s.buildTree(new int[]{}, new int[]{});
    System.out.println(TreeNodeUtil.bfsBrowse(treeNode));
  }

  @Test
  public void test3() {
    Solution s = new Solution();
    TreeNode treeNode = s.buildTree(null, null);
    System.out.println(TreeNodeUtil.bfsBrowse(treeNode));
  }
}
