package shuwei.leetcode.cn.five.four;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> spiralOrder(int[][] matrix) {
    final int right = 0, down = 1, left = 2, up = 3;
    int turn = right;
    int used = 128;
    int xLength = matrix.length;
    int yLength = matrix[0].length;
    int total = xLength * yLength;
    List<Integer> ans = new ArrayList<>(total);
    int i = 0, j = 0;
    int count = 0;
    while (count < total) {
      if (matrix[i][j] != used) {
        ans.add(matrix[i][j]);
        matrix[i][j] = used;
        count++;
      }
      switch (turn) {
        case right:
          if (j + 1 < yLength && matrix[i][j + 1] != used) {
            j++;
          } else {
            turn = down;
          }
          break;
        case down:
          if (i + 1 < xLength && matrix[i + 1][j] != used) {
            i++;
          } else {
            turn = left;
          }
          break;
        case left:
          if (j - 1 >= 0 && matrix[i][j - 1] != used) {
            j--;
          } else {
            turn = up;
          }
          break;
        case up:
          if (i - 1 >= 0 && matrix[i - 1][j] != used) {
            i--;
          } else {
            turn = right;
          }
          break;
        default:
          break;
      }
    }
    return ans;
  }
}
