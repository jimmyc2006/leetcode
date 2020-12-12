package shuwei.leetcode.cn.six.two;

public class Solution {
  /**
   * 从左上往右下计算，每个方块的值是它左边格子的值加上上边格子的值
   * @param m
   * @param n
   * @return
   */
  public int uniquePaths(int m, int n) {
    if (n < 1) {
      return 0;
    }
    int[][] res = new int[m][n];
    res[0][0] = 1;
    for (int i = 0; i < m; i++) {
      for (int j = 0 ; j < n; j++) {
        if (i - 1 >= 0) {
          res[i][j] += res[i - 1][j];
        }
        if (j - 1 >= 0) {
          res[i][j] += res[i][j - 1];
        }
      }
    }
    return res[m - 1][n - 1];
  }
}
