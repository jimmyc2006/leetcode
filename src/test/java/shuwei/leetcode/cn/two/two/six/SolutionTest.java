package shuwei.leetcode.cn.two.two.six;

import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;
import shuwei.leetcode.cn.TreeNodeUtil;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    TreeNode root = TreeNode.gen("4,2,7,1,3,6,9");
    System.out.println(TreeNodeUtil.bfsBrowse(root));
    s.invertTree(root);
    System.out.println(TreeNodeUtil.bfsBrowse(root));
  }

}
