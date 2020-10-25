package shuwei.leetcode.cn.eight.four.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.longestMountain(new int[]{0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1}));
        Assert.assertEquals(4, s.longestMountain(new int[]{875, 884, 239, 731, 723, 685}));
        Assert.assertEquals(0, s.longestMountain(new int[]{2, 3, 3, 2, 0, 2}));
        Assert.assertEquals(0, s.longestMountain(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Assert.assertEquals(11, s.longestMountain(new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0}));
        Assert.assertEquals(5, s.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
        Assert.assertEquals(0, s.longestMountain(new int[]{2, 2, 2}));
    }
}
