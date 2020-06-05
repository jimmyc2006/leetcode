package shuwei.leetcode.cn.mst.two.nine;

public class Solution {
    // 1ms 97%
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return new int[0];
        }
        int[] ans = new int[matrix.length * matrix[0].length];
        int startX = 0;
        int endX = matrix.length;
        int startY = 0;
        int endY = matrix[0].length;

        int index  = 0;
        while (startX < endX && startY < endY) {
            int x = startX;
            int y = startY;
            while (y < endY) {
                ans[index++] = matrix[x][y++];
            }
            y = endY - 1;
            x = startX +1;
            while (x < endX) {
                ans[index++] = matrix[x++][y];
            }
            x = endX - 1;
            y = endY - 2;
            while(y >= startY && x >startX) {
                ans[index++] = matrix[x][y--];
            }
            y = startY;
            x = endX - 2;
            while(x > startX && y < endY - 1) {
                ans[index++] = matrix[x--][y];
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return ans;
    }
}
