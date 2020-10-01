package shuwei.leetcode.cn.six.one.seven;

import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;
import shuwei.leetcode.cn.TreeNodeUtil;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    TreeNode treeNode = s.mergeTrees(TreeNode.gen("1,3,2,5"), TreeNode.gen("2,1,3,null,4,null,7"));
    System.out.println(TreeNodeUtil.bfsBrowse(treeNode));
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    TreeNode treeNode = s.mergeTrees(null, TreeNode.gen("2,1,3,null,4,null,7"));
    System.out.println(TreeNodeUtil.bfsBrowse(treeNode));
  }

  @Test
  public void test3() {
    Solution s = new Solution();
    TreeNode treeNode = s.mergeTrees(null, null);
    System.out.println(TreeNodeUtil.bfsBrowse(treeNode));
  }

}
