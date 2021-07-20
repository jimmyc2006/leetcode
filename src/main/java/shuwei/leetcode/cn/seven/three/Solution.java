package shuwei.leetcode.cn.seven.three;

public class Solution {

  /**
   * 为了不使用额外的空间 第一行用来表哪列需要设置为0
   */
  public void setZeroes(int[][] matrix) {
    int lengthX = matrix.length;
    int lengthY = matrix[0].length;
    boolean hasZero= false;
    for (int i = 0; i < lengthY; i++) {
      if (matrix[0][i] == 0) {
        hasZero = true;
      }
    }
    boolean isZero;
    for (int i = 1; i < lengthX; i++) {
      isZero = false;
      for (int j = 0; j < lengthY; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          if (!isZero) {
            isZero = true;
            for (int k = 0; k < j; k++) {
              matrix[i][k] = 0;
            }
          }
        } else if(isZero){
          matrix[i][j] = 0;
        }
      }
    }
    for (int i = 0; i < lengthY; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 0; j < lengthX; j++) {
          matrix[j][i] = 0;
        }
      }
      if (hasZero) {
        matrix[0][i] = 0;
      }
    }
  }
}
