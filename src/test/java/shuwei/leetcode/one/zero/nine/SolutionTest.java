package shuwei.leetcode.one.zero.nine;

import org.junit.Test;

import shuwei.leetcode.cn.ListNode;
import shuwei.leetcode.cn.TreeNode;
import shuwei.leetcode.cn.TreeNodeUtil;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    TreeNode treeNode = s.sortedListToBST(ListNode.gen("-10, -3, 0, 5, 9"));
    System.out.println(TreeNodeUtil.bfsBrowse(treeNode));
  }

}
