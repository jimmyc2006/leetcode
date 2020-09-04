package shuwei.leetcode.cn.two.five.seven;

import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(s.binaryTreePaths(TreeNode.gen("1,2,3,null,5")));
    System.out.println(s.binaryTreePaths(TreeNode.gen("1,22,33,null,55")));
  }

}
