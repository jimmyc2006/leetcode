package shuwei.leetcode.cn.eight.three.four;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void testAll(){
        test();
        test1();
        test2();
        test3();
        test4();
    }

    @Test
    public void test() {
        Solution s = new Solution();
        int[] ints = s.sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3},
                {2, 4}, {2, 5}});
        System.out.println(Arrays.toString(ints));
        Assert.assertArrayEquals(new int[]{8, 12, 6, 10, 10, 10}, ints);
    }

    @Test
    public void test1() {
        Solution s = new Solution();
        int[] ints = s.sumOfDistancesInTree(4, new int[][]{{2, 0}, {3, 1}, {2, 1}});
        Assert.assertArrayEquals(new int[]{6, 4, 4, 6}, ints);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        int[] ints = s.sumOfDistancesInTree(4, new int[][]{{1, 2}, {2, 0}, {0, 3}});
        System.out.println(Arrays.toString(ints));
        Assert.assertArrayEquals(new int[]{4, 6, 4, 6}, ints);
    }

    @Test
    public void test3() {
        Solution s = new Solution();
        int[] ints = s.sumOfDistancesInTree(4, new int[][]{{1, 2}, {3, 2}, {3, 0}});
        System.out.println(Arrays.toString(ints));
        Assert.assertArrayEquals(new int[]{6, 6, 4, 4}, ints);
    }

    @Test
    public void test4() {
        Solution s = new Solution();
        int[] ints = s.sumOfDistancesInTree(1, new int[][]{{}});
        System.out.println(Arrays.toString(ints));
        Assert.assertArrayEquals(new int[]{0}, ints);
    }
}
