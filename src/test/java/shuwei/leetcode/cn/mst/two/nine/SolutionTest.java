package shuwei.leetcode.cn.mst.two.nine;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7}, s.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5}, s.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        Assert.assertArrayEquals(new int[]{6, 9, 7}, s.spiralOrder(new int[][]{{6, 9, 7}}));
        Assert.assertArrayEquals(new int[]{6, 9, 7}, s.spiralOrder(new int[][]{{6}, {9}, {7}}));
    }

    @Test
    public void tes2() {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.spiralOrder(new int[][]{{6}, {9}, {7}})));
    }
}
