package shuwei.leetcode.cn.five.three.eight;

import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;
import shuwei.leetcode.cn.TreeNodeUtil;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    TreeNode treeNode = s.convertBST(TreeNode.gen("5,2,13"));
    System.out.println(TreeNodeUtil.bfsBrowse(treeNode));
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    TreeNode treeNode = s.convertBST(TreeNode.gen("2,0,3,-4,1"));
    System.out.println(TreeNodeUtil.bfsBrowse(treeNode));
  }

  // 8,8,4,6,null,7
  @Test
  public void test3() {
    Solution s = new Solution();
    TreeNode treeNode = s.convertBST(TreeNode.gen("1,0,4,-2,null,3"));
    System.out.println(TreeNodeUtil.bfsBrowse(treeNode));
  }
}


