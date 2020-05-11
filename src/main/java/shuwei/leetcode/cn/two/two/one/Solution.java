package shuwei.leetcode.cn.two.two.one;

public class Solution {
  // 思路，从左上往右下遍历，每个点都判断它是否是正方形的右下顶点
  // 5ms,打败94%，代码形式上可以继续优化
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length < 1) {
      return 0;
    }
    // 坐标跟matrix一样，值是组成的正方形的面积
    int[][] square = new int[matrix.length][matrix[0].length];
    int maxArea = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        maxArea = Math.max(maxArea, squareArea(matrix, square, i, j));
      }
    }
    return maxArea;
  }

  private int squareArea(char[][] matrix, int[][] square, int i, int j) {
    if (matrix[i][j] != '1') {
      return 0;
    }
    if (i > 0 && j > 0) {
      if (square[i - 1][j - 1] != 0) {
        boolean isSquare = true;
        // 判断能否包含这个正方形
        for (int k = 1; k <= square[i - 1][j - 1]; k++) {
          // 往左往上检查
          if (matrix[i - k][j] != '1' || matrix[i][j - k] != '1') {
            square[i][j] = k;
            isSquare = false;
            break;
          }
        }
        if (isSquare) {
          square[i][j] = square[i - 1][j - 1] + 1;
          return square[i][j] * square[i][j];
        }
      } else {
        // 判断能否创建一个面积为4的正方形
        if (matrix[i - 1][j] == '1' && matrix[i - 1][j - 1] == '1' && matrix[i][j - 1] == '1') {
          square[i][j] = 2;
          return 4;
        }
      }
    }
    return 1;
  }
}
