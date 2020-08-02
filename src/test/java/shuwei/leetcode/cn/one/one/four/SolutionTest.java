package shuwei.leetcode.cn.one.one.four;

import org.junit.Test;

import shuwei.leetcode.cn.TreeNode;
import shuwei.leetcode.cn.TreeNodeUtil;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    TreeNode tn = TreeNode.gen("1,2,5,3,4,null,6");
    System.out.println(TreeNodeUtil.bfsBrowse(tn));
    s.flatten(tn);
    System.out.println(TreeNodeUtil.bfsBrowse(tn));
    TreeNodeUtil.beforeB(tn);
    s.flatten(null);
  }
}
