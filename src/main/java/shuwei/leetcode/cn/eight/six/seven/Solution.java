package shuwei.leetcode.cn.eight.six.seven;

public class Solution {

  /**
   * 123
   * 456
   * 14
   * 25
   * 36
   * 将原来x行y列的数组变为y行x列
   * @param matrix
   * @return
   */
  public int[][] transpose(int[][] matrix) {
    int xLength = matrix.length, yLength = matrix[0].length;
    int[][] result = new int[yLength][xLength];
    for (int i = 0; i < xLength; i++) {
      for (int j = 0; j < yLength; j++) {
        result[j][i] = matrix[i][j];
      }
    }
    return result;
  }

}
