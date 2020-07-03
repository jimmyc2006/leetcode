package shuwei.leetcode.cn.one.zero.eight;

import org.junit.Assert;
import org.junit.Test;
import shuwei.leetcode.cn.TreeNode;
import shuwei.leetcode.cn.TreeNodeUtil;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        TreeNode treeNode = s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        Assert.assertEquals("0,-3,9,-10,null,5,null,", TreeNodeUtil.bfsBrowse(treeNode));
        treeNode = s.sortedArrayToBST(new int[]{-10});
        System.out.println(TreeNodeUtil.bfsBrowse(treeNode));
    }
}
