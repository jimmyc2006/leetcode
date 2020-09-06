package shuwei.leetcode.cn.one.zero.seven;

import org.junit.Test;

import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    for (List<Integer> ele : s.levelOrderBottom(TreeNode.gen("3,9,20,null,null,15,7"))) {
      System.out.println(ele);
    }
  }

}
