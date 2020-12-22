package shuwei.leetcode.cn.one.zero.three;

import org.junit.Test;

import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    List<List<Integer>> lists = s.zigzagLevelOrder(TreeNode.gen("3,9,20,null,null,15,7"));
    for (List<Integer> ele : lists) {
      System.out.println(ele);
    }
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    List<List<Integer>> lists = s.zigzagLevelOrder(TreeNode.gen("1"));
    for (List<Integer> ele : lists) {
      System.out.println(ele);
    }
  }
}
