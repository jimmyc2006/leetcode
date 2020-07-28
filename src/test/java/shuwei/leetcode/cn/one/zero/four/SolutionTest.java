package shuwei.leetcode.cn.one.zero.four;

import org.junit.Assert;
import org.junit.Test;
import shuwei.leetcode.cn.TreeNode;
import shuwei.leetcode.cn.TreeNodeUtil;

public class SolutionTest {
    @Test
    public void test() {
       Solution s = new Solution();
        Assert.assertEquals(3, s.maxDepth(TreeNode.gen("3,9,20,null,null,15,7")));
        Assert.assertEquals(0, s.maxDepth(null));
    }
}
