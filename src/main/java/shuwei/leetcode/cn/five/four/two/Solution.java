package shuwei.leetcode.cn.five.four.two;

public class Solution {
  public int[][] updateMatrix(int[][] matrix) {
    if (matrix.length < 1 || matrix[0].length < 1) {
      return matrix;
    }
    int max = 10000;
    int xMax = matrix.length;
    int yMax = matrix[0].length;
    int[][] f = new int[xMax][yMax];

    for (int i = 0 ; i < xMax; i++) {
      for (int j = 0; j < yMax; j++) {
        if (matrix[i][j] == 0) {
          f[i][j] = 0;
        } else {
          f[i][j] = max;
          if (i - 1 >= 0) {
            f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j]);
          }
          if (j - 1 >= 0) {
            f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
          }
        }
      }
    }
    for (int i = xMax - 1; i >= 0; i--) {
      for (int j = yMax - 1; j >= 0; j--) {
        if (matrix[i][j] == 0) {
          f[i][j] = 0;
        } else {
          if (i + 1 < xMax) {
            f[i][j] = Math.min(f[i][j], f[i + 1][j] + 1);
          }
          if (j + 1 < yMax) {
            f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
          }
        }
      }
    }
    return f;
  }
}

