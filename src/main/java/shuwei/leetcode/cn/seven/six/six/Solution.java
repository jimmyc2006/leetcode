package shuwei.leetcode.cn.seven.six.six;

public class Solution {

  /**
   * 分为坐下和右上三角检查
   * @param matrix
   * @return
   */
  public boolean isToeplitzMatrix(int[][] matrix) {
    int xLength = matrix.length;
    int yLength = matrix[0].length;
    // 从第二行开始，每个值需要等于它左上的值，如果存在的话
    for (int i = 1; i < xLength; i++) {
      for (int j = 1; j < yLength; j++) {
        if (matrix[i][j] != matrix[i - 1][j - 1]) {
          return false;
        }
      }
    }
    return true;
  }
}
