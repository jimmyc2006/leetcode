package shuwei.leetcode.cn.three.two.nine;

public class Solution {
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix.length < 1 || matrix[0].length < 1) {
      return 0;
    }
    // 深度优先，找比自己大的
    data = new int[matrix.length][matrix[0].length];
    int ans = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        ans = Math.max(ans, findBigger(matrix, i, j));
      }
    }
    return ans;
  }

  int[][] data;

  private int findBigger(int[][] matrix, int x, int y) {
    if (data[x][y] != 0) {
      return data[x][y];
    }
    int max = 1;
    // 上
    if (x - 1 >= 0 && matrix[x - 1][y] > matrix[x][y]) {
      max = findBigger(matrix, x - 1, y) + 1;
    }
    // 下
    if (x + 1 < matrix.length && matrix[x + 1][y] > matrix[x][y]) {
      max = Math.max(max, findBigger(matrix, x + 1, y) + 1);
    }
    // 左
    if(y - 1 >= 0 && matrix[x][y - 1] > matrix[x][y]) {
      max = Math.max(max, findBigger(matrix, x, y - 1) + 1);
    }
    // 右
    if (y + 1 < matrix[x].length && matrix[x][y + 1] > matrix[x][y]) {
      max = Math.max(max, findBigger(matrix, x, y + 1) + 1);
    }
    data[x][y] = max;
    return max;
  }
}
