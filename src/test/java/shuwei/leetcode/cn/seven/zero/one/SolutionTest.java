package shuwei.leetcode.cn.seven.zero.one;

import org.junit.Test;
import shuwei.leetcode.cn.TreeNode;
import shuwei.leetcode.cn.TreeNodeUtil;

public class SolutionTest {

    @Test
    public void test(){
        Solution s = new Solution();
        TreeNode treeNode = s.insertIntoBST(TreeNode.gen("4,2,7,1,3,null,null"), 5);
        String s1 = TreeNodeUtil.bfsBrowse(treeNode);
        System.out.println(s1);
    }
}
