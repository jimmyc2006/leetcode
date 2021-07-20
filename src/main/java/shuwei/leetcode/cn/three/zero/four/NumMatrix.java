package shuwei.leetcode.cn.three.zero.four;

public class NumMatrix {

  private int[][] prefixSum;

  public NumMatrix(int[][] matrix) {
    int xLength = matrix.length;
    if (xLength == 0) {
      return;
    }
    int yLength = matrix[0].length;
    prefixSum = new int[xLength][yLength];
    for (int i = 0; i < matrix.length; i++) {
      int currSum = 0;
      for (int j = 0; j < matrix[i].length; j++) {
        currSum += matrix[i][j];
        prefixSum[i][j] = currSum;
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int res = 0;
    for (int i = row1; i <= row2; i++) {
      if (col1 > 0) {
        res += prefixSum[i][col2] - prefixSum[i][col1 - 1];
      } else {
        res += prefixSum[i][col2];
      }
    }
    return res;
  }
}
