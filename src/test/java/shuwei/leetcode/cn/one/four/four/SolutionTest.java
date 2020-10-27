package shuwei.leetcode.cn.one.four.four;

import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(s.preorderTraversal(TreeNode.gen("1,null,2,3")));
    System.out.println(s.preorderTraversal(TreeNode.gen("1,2,3,4,5,6,7,8,9")));
  }

}
