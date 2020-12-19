package shuwei.leetcode.cn.four.eight;

public class Solution {

    /**
     * 画圈的方法
     * 从0到n-2
     * 从1到n-3
     * 从2到n-4
     * ...
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if(matrix.length <= 1) {
            return;
        }
        data = matrix;
        n = data.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < n - i - 1; j++) {
                deal(i, j);
            }
        }
    }

    private int[][] data;
    private int n = 0;

    /**
     * 交换位置
     * 0,0, -> 0,n-1    <1>横坐标=纵坐标，纵坐标n - 1 - x
     * 0,n-1 -> n-1,n - 1   <2>横坐标=纵坐标，横坐标变成 n-1-x
     * n - 1,n - 1 -> n-1,0 <3>横坐标=纵坐标，横坐标变成 n-1-x</3>
     * 0,1 -> 1, n-1-y 正坐标变成总
     *
     * @param x
     * @param y
     */
    private void deal(int x, int y) {
        int temp = data[x][y];
        int nextX = y;
        int nextY = n - 1 - x;
        for (int i = 0; i <= 3; i++) {
            temp = swap(temp, nextX, nextY);
            int xx = nextX;
            nextX = nextY;
            nextY = n - 1 - xx;
        }
    }

    private int swap(int temp, int dstX, int dstY) {
        int res = data[dstX][dstY];
        data[dstX][dstY] = temp;
        return res;
    }
}
