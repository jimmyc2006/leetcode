package shuwei.leetcode.cn.five.two;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.totalNQueens(4));
        Assert.assertEquals(1, s.totalNQueens(1));
    }

}
