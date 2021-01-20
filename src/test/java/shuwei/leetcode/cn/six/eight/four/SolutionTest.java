package shuwei.leetcode.cn.six.eight.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Assert.assertArrayEquals(new int[]{8, 9}, s.findRedundantConnection(new int[][]{{3, 7}, {1, 4}, {2, 8}, {1, 6}, {7, 9}, {6, 10}, {1, 7}, {2, 3}, {8, 9}, {5, 9}}));
            Assert.assertArrayEquals(new int[]{4, 10}, s.findRedundantConnection(new int[][]{{9, 10}, {5, 8}, {2, 6}, {1, 5}, {3, 8}, {4, 9}, {8, 10}, {4, 10}, {6, 8}, {7, 9}}));
            Assert.assertArrayEquals(new int[]{1, 4}, s.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}));
            Assert.assertArrayEquals(new int[]{2, 3}, s.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
