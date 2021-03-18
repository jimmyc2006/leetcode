package shuwei.leetcode.cn.five.nine;

public class Solution {

  public int[][] generateMatrix(int n) {
    final int right = 0, down = 1, left = 2, up = 3;
    int curr = 1;
    int turn = right;
    int[][] ans = new int[n][n];
    int total = n * n;
    int i = 0, j = 0;
    while (curr <= total) {
      if (ans[i][j] == 0) {
        ans[i][j] = curr++;
      }
      switch (turn) {
        case right:
          if (j + 1 < n && ans[i][j + 1] == 0) {
            j++;
          } else {
            turn = down;
          }
          break;
        case down:
          if (i + 1 < n && ans[i + 1][j] == 0) {
            i++;
          } else {
            turn = left;
          }
          break;
        case left:
          if (j - 1 >= 0 && ans[i][j - 1] == 0) {
            j--;
          } else {
            turn = up;
          }
          break;
        case up:
          if (i - 1 >= 0 && ans[i - 1][j] == 0) {
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
