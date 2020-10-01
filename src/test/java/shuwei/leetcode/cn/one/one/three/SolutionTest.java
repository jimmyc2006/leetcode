package shuwei.leetcode.cn.one.one.three;

import org.junit.Test;

import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    List<List<Integer>> lists = s.pathSum(TreeNode.gen("5,4,8,11,null,13,4,7,2,null,null,5,1"), 22);
    for (List<Integer> ele : lists) {
      System.out.println(ele);
    }
  }
}
