package shuwei.leetcode.cn.nine.four;

import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(s.inorderTraversal(TreeNode.gen("1,null,2,3,null")));
  }
}
