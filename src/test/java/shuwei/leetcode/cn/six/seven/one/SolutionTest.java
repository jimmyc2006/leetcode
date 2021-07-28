package shuwei.leetcode.cn.six.seven.one;

import org.junit.Assert;
import org.junit.Test;
import shuwei.leetcode.cn.TreeNode;

public class SolutionTest {
    @Test
    public void test() {
        Solution soluton = new Solution();
        Assert.assertEquals(5, soluton.findSecondMinimumValue(TreeNode.gen("2,2,5,null,null,5,7")));
        Assert.assertEquals(2, soluton.findSecondMinimumValue(TreeNode.gen("1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1")));
        Assert.assertEquals(-1, soluton.findSecondMinimumValue(TreeNode.gen("2,2,2")));
    }
}
