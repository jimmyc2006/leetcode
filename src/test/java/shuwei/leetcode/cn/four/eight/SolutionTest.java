package shuwei.leetcode.cn.four.eight;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        int[][] data = new int[][]{{1,2,3},{4,5,6}, {7,8,9}};
        s.rotate(data);
        print(data);
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        int[][] data = new int[][]{
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}};
        s.rotate(data);
        print(data);
    }

    private void print(int[][] data) {
        for (int[] ele : data) {
            System.out.println(Arrays.toString(ele));
        }
    }
}
