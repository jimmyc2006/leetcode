package shuwei.leetcode.cn.matrix01;

import java.util.Arrays;

/**
 * @author shuwei 创建时间：2020年4月15日 下午5:47:07
 */
// 动态规划版本-遍历4遍二位数组，分别是左上，右上，左下，右下
// 注意左上是从左上角的点开始，每个点往左上算
// 我自己的思路是直接找到那个点，向上下左右4个方向扩散，结果会死循环，因为没有方向，会互相访问
// 最后得出只往左上和右下就能得出正确的结果，至于4个方向为什么会变成2个方向，因为一个点的值只可能是来自上下左右，并不能来自斜线
public class Solution {
  public static void main(String[] args) {
//     int[][] data = new int[][] {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
//     {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
//     {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
//     {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
//     {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
//     int[][] data = new int[][] {{0}, {1}};
    int[][] data = new int[][] {
      {1, 1, 0, 0, 1, 0, 0, 1, 1, 0}, 
      {1, 0, 0, 1, 0, 1, 1, 1, 1, 0},
      {1, 1, 1, 0, 0, 1, 1, 1, 1, 1}, 
      {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
      {0, 0, 1, 1, 1, 1, 1, 1, 1, 0}, 
      {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
      {0, 1, 1, 1, 1, 1, 1, 0, 0, 1}, 
      {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
      {0, 1, 0, 1, 1, 0, 1, 1, 1, 1}, 
      {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}};
    Solution s = new Solution();
    int[][] result = s.updateMatrix(data);
    for (int i = 0; i < result.length; i++) {
      System.out.println(Arrays.toString(result[i]));
    }
  }

  public int[][] updateMatrix(int[][] matrix) {
    int lengthX = matrix.length;
    int lengthY = matrix[0].length;
    int[][] result = new int[lengthX][lengthY];
    for (int i = 0; i < lengthX; i++) {
      Arrays.fill(result[i], lengthX * lengthY);
    }
    for (int i = 0; i < lengthX; i++) {
      for (int j = 0; j < lengthY; j++) {
        if (matrix[i][j] == 0) {
          result[i][j] = 0;
        }
      }
    }
    // 往左上
    for (int i = 0; i < lengthX; i++) {
      for (int j = 0; j < lengthY; j++) {
        if (i > 0) {
          result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
        }
        if (j > 0) {
          result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
        }
      }
    }
    // 往右下
    for (int i = lengthX - 1; i >= 0; i--) {
      for (int j = lengthY - 1; j >= 0; j--) {
        if (i + 1 < lengthX) {
          result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
        }
        if (j + 1 < lengthY) {
          result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
        }
      }
    }
//    // 往右上
//    for (int i = 0; i < lengthX; i++) {
//      for (int j = lengthY - 1; j >= 0; j--) {
//        if (i > 0) {
//          result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
//        }
//        if (j + 1 < lengthY) {
//          result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
//        }
//      }
//    }
//    // 往左下
//    for (int i = lengthX - 1; i >= 0; i--) {
//      for (int j = 0; j < lengthY; j++) {
//        if (i > 0) {
//          result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
//        }
//        if (j + 1 < lengthY) {
//          result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
//        }
//      }
//    }
    return result;
  }
}
