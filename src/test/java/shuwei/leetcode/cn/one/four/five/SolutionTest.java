package shuwei.leetcode.cn.one.four.five;

import org.junit.Test;

import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    List<Integer> integers = s.postorderTraversal(TreeNode.gen("1,null,2,3"));
    System.out.println(integers);
  }

}
