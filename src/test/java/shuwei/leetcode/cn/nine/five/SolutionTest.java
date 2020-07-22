package shuwei.leetcode.cn.nine.five;

import org.junit.Test;

import java.util.List;

import shuwei.leetcode.cn.TreeNode;
import shuwei.leetcode.cn.TreeNodeUtil;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    List<TreeNode> treeNodes = s.generateTrees(5);
    System.out.println(treeNodes.size());
    for (TreeNode tn : treeNodes) {
      System.out.println(TreeNodeUtil.bfsBrowse(tn));
    }
  }

}