package shuwei.leetcode.cn.three.three.seven;

import org.junit.Assert;
import org.junit.Test;
import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {
    @Test
    public void test() {
       Solution s = new Solution();
        Assert.assertEquals(7, s.rob(TreeNode.gen("3,2,3,null,3,null,1")));
        Assert.assertEquals(9, s.rob(TreeNode.gen("3,4,5,1,3,null,1")));
    }
}
