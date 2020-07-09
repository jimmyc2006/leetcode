package shuwei.leetcode.cn.six.three;

public class Solution {
    // BFS的时候会出现重复求某个块的值的情况，所以采用dp
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int lengthI = obstacleGrid.length, lengthJ = obstacleGrid[0].length;
        int[][] f = new int[lengthI][lengthJ];
        if (obstacleGrid[lengthI - 1][lengthJ - 1] == 0) {
            f[lengthI - 1][lengthJ - 1] = 1;
        }
        // 初始化最后一行
        int i = lengthI - 1;
        for (int j = lengthJ - 2; j >= 0; j--) {
            if (obstacleGrid[i][j] == 0){
                f[lengthI - 1][j] = f[i][j +1];
            }
        }
        // 初始化最后一列
        int j = lengthJ - 1;
        for (i = lengthI - 2; i >= 0; i--) {
            if (obstacleGrid[i][j] == 0) {
                f[i][lengthJ - 1] = f[i + 1][j];
            }
        }
        for (i = lengthI - 2; i >= 0 ; i--) {
            for (j = lengthJ - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    f[i][j] = f[i + 1][j] + f[i][j + 1];
                } else {
                    f[i][j] = 0;
                }
            }
        }
        return f[0][0];
    }
}
