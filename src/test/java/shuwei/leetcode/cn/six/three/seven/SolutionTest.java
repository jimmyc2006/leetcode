package shuwei.leetcode.cn.six.three.seven;

import org.junit.Test;

import java.util.List;

import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    List<Double> doubles = s.averageOfLevels(TreeNode.gen("3,9,20,null,null,15,7"));
    System.out.println(doubles);
    // [3.0, 14.5, 11.0]
  }

  @Test
  public void test1() {
    Solution s = new Solution();
    List<Double> doubles = s.averageOfLevels(TreeNode.gen("2147483647,2147483647,2147483647]"));
    System.out.println(doubles);
  }
}
