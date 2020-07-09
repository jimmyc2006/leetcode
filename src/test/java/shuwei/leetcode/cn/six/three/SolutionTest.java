package shuwei.leetcode.cn.six.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        Assert.assertEquals(1, s.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        Assert.assertEquals(0, s.uniquePathsWithObstacles(new int[][]{{0, 1}, {1, 0}}));
        Assert.assertEquals(0, s.uniquePathsWithObstacles(new int[][]{{1}}));
    }
}
