package shuwei.leetcode.cn.six.four;

public class Solution {
  public int minPathSum(int[][] grid) {
    if (grid.length < 1 || grid[0].length < 1) {
      return 0;
    }
    int lenX = grid.length;
    int lenY = grid[0].length;
    int[] f = new int[lenY];
    for (int i = lenX - 1; i >= 0; i--) {
      for (int j = lenY - 1; j >= 0; j--) {
        if (i + 1 < lenX && j + 1 < lenY) {
          f[j] = grid[i][j] + Math.min(f[j], f[j + 1]);
        } else if (i + 1 < lenX) {
          f[j] = grid[i][j] + f[j];
        } else if (j + 1 < lenY) {
          f[j] = grid[i][j] + f[j + 1];
        } else {
          f[j] = grid[i][j];
        }
      }
    }
    return f[0];
  }
}
