package shuwei.leetcode.cn.one.zero.two.eight;

import org.junit.Test;
import shuwei.leetcode.cn.TreeNode;
import shuwei.leetcode.cn.TreeNodeUtil;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
//        TreeNode tn = s.recoverFromPreorder("1-2--3--4-5--6--7");
//        System.out.println(TreeNodeUtil.bfsBrowse(tn));
        TreeNode tn2 = s.recoverFromPreorder("1-401--349---90--88");
        System.out.println(TreeNodeUtil.bfsBrowse(tn2));
    }
}
